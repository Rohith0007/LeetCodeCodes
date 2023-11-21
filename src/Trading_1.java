import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Trading_1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        TradeAggregator agg = new TradeAggregator();
        while ((line = in.readLine()) != null) {
            String[] tokens = line.split(" ");
            String command = tokens[0];

            if (command.equalsIgnoreCase("Trade"))
            {
                agg.HandleTrade(ParseTrade(tokens));
            }
            else
            {
                agg.HandleTheoUpdate(ParseTheoUpdate(tokens));
            }
        }
    }

    static class Trade
    {
        public Trade(String trader, int asset, int quantity, double price)
        {
            Trader = trader;
            Asset = asset;
            Quantity = quantity;
            Price = price;
        }
        public String Trader;
        public int Asset;
        public int Quantity;
        public double Price;
    };

    public static Trade ParseTrade(String[] tokens)
    {
        String trader = tokens[1];
        int asset = Integer.parseInt(tokens[2]);
        int quantity = Integer.parseInt(tokens[3]);
        double price = Double.parseDouble(tokens[4]);
        return new Trade(trader, asset, quantity, price);
    }

    static class TheoUpdate
    {
        public TheoUpdate(int asset, double value)
        {
            Asset = asset;
            Value = value;
        }
        public int Asset;
        public double Value;
    };

    public static TheoUpdate ParseTheoUpdate(String[] tokens)
    {
        int asset = Integer.parseInt(tokens[1]);
        double value = Double.parseDouble(tokens[2]);
        return new TheoUpdate(asset, value);
    }

    public static class TradeAggregator {

        private Map<String, Double> traderScores = new HashMap<>();
        private Map<Integer, Double> theoreticalValues = new HashMap<>();

        public TradeAggregator() {
            // Initialize TradeAggregator if needed
        }

        public void HandleTrade(Trade trade) {
            double theoreticalValue = theoreticalValues.getOrDefault(trade.Asset, trade.Price);
            double edge = calculateEdge(theoreticalValue, trade.Price, trade.Quantity);
            updateScore(trade.Trader.toLowerCase(), (int) edge, Math.abs(trade.Quantity));
            printTraderScores();
        }

        public void HandleTheoUpdate(TheoUpdate theoUpdate) {
            theoreticalValues.put(theoUpdate.Asset, theoUpdate.Value);
        }

        private double calculateEdge(double theoreticalValue, double tradePrice, int quantity) {
            if (quantity > 0) {
                return theoreticalValue - tradePrice;
            } else {
                return tradePrice - theoreticalValue;
            }
        }

        private void updateScore(String traderName, int edge, int quantity) {
            double score = traderScores.getOrDefault(traderName, 0.0);
            score += Math.signum(edge) * edge * quantity;
            traderScores.put(traderName, score);
        }

        private void printTraderScores() {
            List<String> traderNames = new ArrayList<>(traderScores.keySet());
            Collections.sort(traderNames);

            for (String traderName : traderNames) {
                PrintTraderScore(traderName, traderScores.get(traderName));
            }
        }

        public void PrintTraderScore(String traderName, double score) {
            System.out.printf("%s %.2f\n", traderName, score);
        }
    }

}