package lotto.domain.user;

import lotto.collection.Lotto;
import lotto.collection.LottoTickets;
import lotto.collection.WinningNumbers;
import lotto.util.Validator;
import lotto.util.UserIdGenerator;

public class User {

    private final int id;
    private final int purchasePrice;
    private final LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;
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

    public void addRevenue(long revenue) {
        this.revenue += revenue;
    }

    public void addWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
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

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public long getRevenue() {
        return revenue;
    }
}
