package lotto;

import java.util.ArrayList;
import java.util.List;

public class Seller {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> issueLottoesWith(Money money) {
        validateNoChanges(money);
        return issueRandomLottoes(money.countAvailableFrom(LOTTO_PRICE));
    }

    private void validateNoChanges(Money money) {
        if (money.hasChangeWith(LOTTO_PRICE)) {
            throw new IllegalArgumentException("금액이 나눠 떨어지지 않습니다");
        }
    }

    private List<Lotto> issueRandomLottoes(long count) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoes.add(Lotto.createRandomized());
        }
        return lottoes;
    }
}
