package lotto.domain.user;

import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.util.UserIdGenerator;
import lotto.util.Validator;

public class User {

    private final int id;
    private final int purchasePrice;
    private final LottoTickets lottoTickets;
    private long revenue;

    public User(String purchasePrice) {
        validate(purchasePrice);
        this.id = UserIdGenerator.generateId();
        this.purchasePrice = Integer.parseInt(purchasePrice);
        this.lottoTickets = new LottoTickets();
        this.revenue = 0;
    }

    private void validate(String purchasePrice) {
        Validator.checkPurchasePrice(purchasePrice);
    }

    // setter
    public void addLotto(Lotto lotto) {
        this.lottoTickets.addLotto(lotto);
    }

    public void addRevenue(long winningPrice) {
        this.revenue += winningPrice;
    }

    public double getRateOfReturn() {
        double rateOfRevenue = generateRevenueRate(this.revenue);

        // 수익률이 음수일 경우 100.0을 더함
        if(rateOfRevenue < 0.0) {
            rateOfRevenue += 100.0;
        }
        return rateOfRevenue;
    }

    private double generateRevenueRate(long revenue) {
        double originalRevenue = ((double) (revenue - purchasePrice) / purchasePrice) * 100;
        return Math.round(originalRevenue * 10.0) / 10.0;
    }

    // getter
    public int getId() {
        return id;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
