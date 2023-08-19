import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XmlParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("booking.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList bookings = document.getElementsByTagName("booking");

            HTMLGenerator htmlGenerator = new HTMLGenerator();
            htmlGenerator.generateTableHeader();

            for (int i = 0; i < bookings.getLength(); i++) {
                Node booking = bookings.item(i);
                if (booking.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) booking;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String destination = element.getElementsByTagName("destination").item(0).getTextContent();
                    String tickets = element.getElementsByTagName("tickets").item(0).getTextContent();

                    htmlGenerator.generateTableRow(name, destination, tickets);
                }
            }

            htmlGenerator.generateTableFooter();
            saveHTMLToFile(htmlGenerator.getGeneratedHTML());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveHTMLToFile(String htmlContent) {
        try {
            FileWriter fileWriter = new FileWriter("booking_data.html");
            fileWriter.write(htmlContent);
            fileWriter.close();
            System.out.println("Generated HTML saved to booking_data.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
