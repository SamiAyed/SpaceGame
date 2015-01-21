package com.game.src.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;


public class GenerXml {
	public String pseudo ="null";
	public String score = "null";
	public String dif = "null";
	
	
	Map<String, String> dictionary = new HashMap<String, String>();
	
	private List<Map> players = new ArrayList<Map>();
	
	
	public void saveToXML(String xml) {
	    Document dom;
	    Element e = null;

	    // instance of a DocumentBuilderFactory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
	        // use factory to get an instance of document builder
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // create instance of DOM
	        dom = db.newDocument();

	        // create the root element
			Element rootEle = dom.createElement("game");

			
//			Element player = dom.createElement("player");
//	        // create data elements and place them under root
//	        e = dom.createElement("pseudo");
//	        e.appendChild(dom.createTextNode(pseudo));
//	        player.appendChild(e);
//
//	        e = dom.createElement("score");
//	        e.appendChild(dom.createTextNode(score));
//	        player.appendChild(e);
//
//	        e = dom.createElement("dif");
//	        e.appendChild(dom.createTextNode(dif));
//	        player.appendChild(e);
//
//			rootEle.appendChild(player);
			
			
			
	        dom.appendChild(rootEle);

	        try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            // send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(xml)));

	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        }
	    } catch (ParserConfigurationException pce) {
	        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
	    }
	}
	
	public List readXML(String xml) {
        //players = new ArrayList<String>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            NodeList list = node.getChildNodes();
            
            pseudo = getTextValue(pseudo, doc, "pseudo");
            if (pseudo != null) {
                if (!pseudo.isEmpty())
                dictionary.put("pseudo", pseudo);
            }
            score = getTextValue(score, doc, "score");
            if (score != null) {
                if (!score.isEmpty())
                	dictionary.put("score", score);
            }
            dif = getTextValue(dif, doc, "dif");
            if (dif != null) {
                if (!dif.isEmpty())
                	dictionary.put("dif", dif);
            }
            
            players.add(dictionary);
            return players;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } 
        catch (SAXException se) {
            System.out.println(se.getMessage());
		} 
            catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return null;
    }

	public void writeXML(String Path)
	{	
		//pseudo="smantacus";
		score=Long.toString(Game.score);
		dif=Game.Diffuculity.toString();
		
		
		 try {
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(Path);
		 
				// Get the root element
				Node game = doc.getFirstChild();
		 
				// Get the staff element , it may not working if tag has spaces, or
				// whatever weird characters in front...it's better to use
				// getElementsByTagName() to get it directly.
				// Node staff = company.getFirstChild();
		 
				// Get the staff element by tag name directly
				//Node staff = doc.getElementsByTagName("staff").item(0);
				
				Element player = doc.createElement("player");
				// update staff attribute
				//NamedNodeMap attr = staff.getAttributes();
				//Node nodeAttr = attr.getNamedItem("id");
				//nodeAttr.setTextContent("2");
		 
				// append a new node to staff
				Element pseudo = doc.createElement("pseudo");
				pseudo.appendChild(doc.createTextNode(this.pseudo));
				player.appendChild(pseudo);
				
				
				Element score = doc.createElement("score");
				score.appendChild(doc.createTextNode(this.score));
				player.appendChild(score);
				
				Element dif = doc.createElement("dif");
				dif.appendChild(doc.createTextNode(this.dif));
				player.appendChild(dif);
		 
				// loop the staff child node
				//NodeList list = staff.getChildNodes();
		 
//				for (int i = 0; i < list.getLength(); i++) {
//		 
//		                   Node node = list.item(i);
//		 
//				   // get the salary element, and update the value
//				   if ("salary".equals(node.getNodeName())) {
//					node.setTextContent("2000000");
//				   }
//		 
//		                   //remove firstname
//				   if ("firstname".equals(node.getNodeName())) {
//					staff.removeChild(node);
//				   }
//		 
//				}
				
				game.appendChild(player);
		 
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(Path));
				transformer.transform(source, result);
		 
				System.out.println("Done");
		 
			   } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
			   } catch (IOException ioe) {
				ioe.printStackTrace();
			   } catch (SAXException sae) {
				sae.printStackTrace();
			   }
	}
	
	
	private String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
}
