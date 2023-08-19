public class HTMLGenerator {
    private StringBuilder tableHTML;

    public HTMLGenerator() {
        tableHTML = new StringBuilder();
    }

    public void generateTableHeader() {
        tableHTML.append("<html><head><title>Booking Data</title></head><body>");
        tableHTML.append("<h1>Booking Data</h1>");
        tableHTML.append("<table border=\"1\">");
        tableHTML.append("<tr><th>Name</th><th>Destination</th><th>Tickets</th></tr>");
    }

    public void generateTableRow(String name, String destination, String tickets) {
        tableHTML.append("<tr><td>").append(name).append("</td><td>").append(destination).append("</td><td>").append(tickets).append("</td></tr>");
    }

    public void generateTableFooter() {
        tableHTML.append("</table></body></html>");
    }

    public String getGeneratedHTML() {
        return tableHTML.toString();
    }
}
