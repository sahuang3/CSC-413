import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TradeManager {
    private final List<Company> companies = new ArrayList<>();
    private static final Random rand = new Random();

    // Update the share prices for each company,
    // simulating the effect of a day's trading.
    public void updatePrices() {
        for (int i = 0; i < companies.size(); i++) {
            companies.get(i).updatePrice();
        }
    }

    // Add a new company with randomly generated
    // parameters to the simulation. See the
    // Company class's constructor for more
    // information.
    public void createCompany() {
        Company c = new Company();
        companies.add(c);
    }

    // To get some subset of the companies,
    // we can randomly select a set of indexes
    // and return only the corresponding
    // Company objects.
    public Company[] sampleCompanies(int x) {
        Company[] sample = new Company[x];
        int r = 0;

        for (int i = 0; i < x; i++) {
             r = rand.nextInt(companies.size());
             sample[i] = companies.get(r);
        }

        return sample;
    }
}
