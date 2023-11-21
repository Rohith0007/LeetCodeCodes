import java.util.Scanner;
public class ClosestColor {

    public static void main(String[] args) {

        String pixels;
        Scanner kb = new Scanner(System.in);
        pixels = kb.next();
        String red = pixels.substring(0, 8);
        String green = pixels.substring(8, 16);
        String blue = pixels.substring(16);

        int redValue = 0, greenValue = 0, blueValue = 0;

        for(int i=0;i<red.length();i++)
        {
            if(red.charAt(i) == '1')
                redValue += Math.pow(2, 7-i);
            if(green.charAt(i) == '1')
                greenValue += Math.pow(2, 7-i);
            if(blue.charAt(i) == '1')
                blueValue += Math.pow(2, 7-i);
        }

        String[] colors = {"Black", "White", "Red", "Green", "Blue"};
        double[] distance = new double[colors.length];

        for(int i=0;i<colors.length;i++) {

            if(colors[i].equalsIgnoreCase("Black"))
                distance[i] = Math.sqrt(Math.pow(redValue,2) + Math.pow(greenValue, 2) + Math.pow(blueValue, 2));
            else if(colors[i].equalsIgnoreCase("White"))
                distance[i] = Math.sqrt(Math.pow(redValue-255,2) + Math.pow(greenValue-255, 2) + Math.pow(blueValue-255, 2));
            else if(colors[i].equalsIgnoreCase("Red"))
                distance[i] = Math.sqrt(Math.pow(redValue-255,2) + Math.pow(greenValue, 2) + Math.pow(blueValue, 2));
            else if(colors[i].equalsIgnoreCase("Green"))
                distance[i] = Math.sqrt(Math.pow(redValue,2) + Math.pow(greenValue-255, 2) + Math.pow(blueValue, 2));
            else
                distance[i] = Math.sqrt(Math.pow(redValue,2) + Math.pow(greenValue, 2) + Math.pow(blueValue-255, 2));
        }

        String closestColor = colors[0];
        double minDistance = distance[0];

        for(int i=1;i<colors.length;i++) {
            if(distance[i] < minDistance)
            {
                minDistance = distance[i];
                closestColor = colors[i];
            }
            else if(distance[i] == minDistance)
                closestColor = "Ambiguous";
        }
        System.out.println(closestColor);
    }
}