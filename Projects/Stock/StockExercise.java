public class StockExercise {
    public static void main(String[] args) {
        // Create 10 simulated companies
        TradeManager manager = new TradeManager();
        for (int i = 0; i < 10; i++) {
            manager.createCompany();
        }

        // Run the simulation for 50 steps to generate
        // a history of stock prices.
        for (int i = 0; i < 50; i++) {
            manager.updatePrices();
        }

        // Get 4 companies from the trade manager
        Company[] c = manager.sampleCompanies(4);

        // Print company's stock price histories
        for (int i = 0; i < 4; i++) {
            System.out.println("Company: " + c[i].getName());
            c[i].printTrend(3);
            System.out.println();
        }
    }
}
