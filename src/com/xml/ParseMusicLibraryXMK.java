package com.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParseMusicLibraryXMK {
    public static void main(String[] args) {
        try {
            File file = new File("src/com/xml/music-library.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nArtistList = doc.getElementsByTagName("artists");

            for (int i = 0; i < nArtistList.getLength(); i++) {
                Node node = nArtistList.item(0);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                NodeList nChildList = ((Element)node).getElementsByTagName("artist");
                for (int j = 0; j < nChildList.getLength(); j++) {
                    Node nChildNode = nChildList.item(j);
                    if (nChildNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nChildNode;
                        System.out.println("Artist ID: " + element.getAttribute("id"));
                        System.out.println("Artist name: " + element.getElementsByTagName("name").item(0).getTextContent().trim());
                    }
                }
            }

            System.out.println("--------------------------------");
            NodeList nAlbumList = doc.getElementsByTagName("albums");

            for (int i = 0; i < nAlbumList.getLength(); i++) {
                Node node = nAlbumList.item(0);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                NodeList nChildList = ((Element)node).getElementsByTagName("album");
                for (int j = 0; j < nChildList.getLength(); j++) {
                    Node nChildNode = nChildList.item(j);
                    if (nChildNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nChildNode;
                        System.out.println("Album ID: " + element.getAttribute("id"));
                        System.out.println("Album name: " + element.getElementsByTagName("title").item(0).getTextContent().trim());
                    }
                }
            }

            System.out.println("--------------------------------");
            NodeList nSongList = doc.getElementsByTagName("songs");

            for (int i = 0; i < nSongList.getLength(); i++) {
                Node node = nSongList.item(0);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                NodeList nChildList = ((Element)node).getElementsByTagName("song");
                for (int j = 0; j < nChildList.getLength(); j++) {
                    Node nChildNode = nChildList.item(j);
                    if (nChildNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nChildNode;
                       // System.out.println("Test name: " + element.getElementsByTagName("artist").item(0).getNodeName());
                        System.out.println("Song ID: " + element.getAttribute("id"));
                        System.out.println("Title: " + element.getElementsByTagName("title").item(0).getTextContent().trim());
                        System.out.println("Artist ID: " + ((Element)element.getElementsByTagName("artist").item(0)).getAttribute("id"));
                        System.out.println("Artist name: " + element.getElementsByTagName("artist").item(0).getTextContent().trim());
                        System.out.println("Album ID: " + ((Element)element.getElementsByTagName("album").item(0)).getAttribute("id"));
                        System.out.println("Album name: " + element.getElementsByTagName("album").item(0).getTextContent().trim());
                    }
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
