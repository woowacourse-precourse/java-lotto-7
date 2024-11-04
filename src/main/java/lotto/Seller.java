package lotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottoesWith(Money money) {
        return issueRandomLottoes(money.countAffordableFor(LOTTO_PRICE));
    }

    private List<Lotto> issueRandomLottoes(long count) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoes.add(Lotto.createRandomized());
        }
        return lottoes;
    }
}
