import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sun {

    public static void main(String[] args) throws IOException {
        String inputData = "5.0,100,5.5,101,6.0,102:L10;5.0,99,5.5,100,6.0,101:L20;";
        List<String[]> dataMatrix = parseInputData(inputData);
        String htmlTable = generateHtmlTable(dataMatrix);
        writeToFile(htmlTable, "output.html");
    }

    public static List<String[]> parseInputData(String inputData) {
        String[] entries = inputData.split(";");
        List<String[]> matrix = new ArrayList<>();

        for (String entry : entries) {
            String[] parts = entry.split(":|,");
            String[] prices = new String[parts.length - 2];
            System.arraycopy(parts, 1, prices, 0, parts.length - 2);
            matrix.add(new String[]{parts[0], String.join(",", prices), parts[parts.length - 1]});
        }

        return matrix;
    }

    public static String generateHtmlTable(List<String[]> dataMatrix) {
        StringBuilder htmlTable = new StringBuilder("<html><head><style>table {border-collapse: collapse;}th,td {border: 1px solid black;padding: 10px;text-align: center;}</style></head><body>");
        htmlTable.append("<table><tr><th>Lock</th>");

        int priceCount = dataMatrix.get(0)[1].split(",").length;
        for (int i = 1; i <= priceCount; i++) {
            htmlTable.append("<th>Price").append(i).append("</th>");
        }
        htmlTable.append("</tr>");

        for (String[] row : dataMatrix) {
            htmlTable.append("<tr><td>").append(row[2]).append("</td>");
            for (String price : row[1].split(",")) {
                htmlTable.append("<td>").append(price).append("</td>");
            }
            htmlTable.append("</tr>");
        }

        htmlTable.append("</table></body></html>");
        return htmlTable.toString();
    }

    public static void writeToFile(String content, String fileName) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }
}
