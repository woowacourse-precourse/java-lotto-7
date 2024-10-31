package lotto.domain;

import lotto.util.InputValidator;
import lotto.util.UserIdGenerator;

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
        InputValidator.run(purchasePrice);
    }

    public void addLotto(Lotto lotto) {
        this.lottoTickets.addLotto(lotto);
    }

    public void addRevenue(long revenue) {
        this.revenue += revenue;
    }

    public int getId() {
        return id;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public long getRevenue() {
        return revenue;
    }
}
