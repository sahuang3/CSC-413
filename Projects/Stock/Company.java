import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Company {
    private int availableShares;
    private double pricePerShare;
    private double priceDelta;
    private Deque<Double> priceHistory = new ArrayDeque<Double>();

    private static final Random rand = new Random();

    // By including a static class variable tracking
    // the largest ID number used by any company object,
    // the constructor method always knows the
    // smallest unused ID number.
    private static int maxId = 0;
    private int id = 0;

    public Company() {
        // Because the maxID variable is static
        // and only incremented in the constructor,
        // maxID will always increase when new
        // Company objects are created.
        id = maxId;
        maxId++;

        // Randomly generate values for the company.
        availableShares = rand.nextInt(500) + 250;
        pricePerShare = rand.nextDouble(150);
        priceDelta = rand.nextDouble(-2, 2);
        priceHistory.add(getSharePrice());
    }

    public String getName() {
        return "C" + id;
    }

    public void addPrice(double p) {
        priceHistory.add(p);
    }

    // Simulate a day of trading and update the stock price.
    public void updatePrice() {
        pricePerShare += priceDelta;
        priceDelta = rand.nextDouble(-2, 2);
        priceHistory.add(getSharePrice());
    }

    public double getSharePrice() {
        return pricePerShare;
    }

    public boolean isAvailable(int x) {
        return availableShares > x;
    }

    public double buyShares(int x) {
        if (!isAvailable(x)) {
            return 0;
        }

        availableShares -= x;

        return x * pricePerShare;
    }

    public double sellShares(int x) {
        availableShares += x;

        return x * pricePerShare;
    }

    // To set the scale of the visualization,
    // we need to know the largest value which
    // will be displayed in the given range.
    private double getMaxHistoricalPrice() {
        Double[] prices = priceHistory.toArray(new Double[0]);
        double maxp = 0.0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > maxp) {
                maxp = prices[i];
            }
        }

        return maxp;
    }

    // To set the scale of the visualization,
    // we need to know the smallest value which
    // will be displayed in the given range.
    private double getMinHistoricalPrice() {
        Double[] prices = priceHistory.toArray(new Double[0]);
        double minp = 99999.0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minp) {
                minp = prices[i];
            }
        }

        return minp;
    }

    // By "overloading" the printTrend method,
    // the user may choose whether to specify
    // only the height of the visualization and
    // scale to the data, or set a custom range
    // for the y-axis.
    public void printTrend(int height) {
        printTrend(height, getMinHistoricalPrice(), getMaxHistoricalPrice());
    }

    public void printTrend(int height, double minPrice, double maxPrice) {
        // DecimalFormat is useful for rounding when printing floating point values.
        // The following DecimalFormat object will print values rounded
        // to two decimal places.
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        // Each row of the graph indicates whether the
        // share price on the ith day falls in a
        // given range. So for each row, we need to
        // print a "*" only if the share price falls
        // within the range of the row, from
        // rowPriceFloor up to (rowPriceFloor + rowPriceDelta).
        String row = "";
        double rowPriceFloor = maxPrice;
        double rowPriceDelta = Math.abs((maxPrice - minPrice) / height);

        // Moving the priceHistory out of the Deque and
        // into an array allows us to more conveniently
        // access the value at a specific index.
        Double[] prices = priceHistory.toArray(new Double[0]);

        System.out.println("$" + df.format(maxPrice));
        for (int i = 0; i < height; i++) {
            // For each row, we reduce the price floor
            // to test if the price on each day is
            // within a different range.
            rowPriceFloor -= rowPriceDelta;

            for (int j = 0; j < priceHistory.size(); j++) {
                // For each day, we check if the price on the jth
                // day falls within the range represented by the
                // current row, only printing a * when true.
                if (prices[j] > rowPriceFloor && prices[j] <= rowPriceFloor + rowPriceDelta) {
                    row += "*";
                } else {
                    row += " ";
                }
            }

            // After iterating over the price history in the
            // inner loop, we have a String showing on which
            // days the stock price was within the given range
            // and when the price was not.
            //
            // A graph is formed when these rows are printed
            // in order from highest price range to lowest.
            System.out.println(row);
            row = "";
        }

        System.out.println("$" + df.format(minPrice));
    }
}
