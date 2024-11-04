package lotto.model;

import static lotto.model.Lotto.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LotteryIssuer implements TicketIssuer {
    private int lotteryCount;

    @Override
    public List<Ticket> issue(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        lotteryCount = purchaseAmount / LOTTO_PRICE;
        List<Ticket> lotteries = new ArrayList<>();
        for (int i = 0; i < lotteryCount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lotteries.add(lotto);
        }
        return lotteries;
    }

    @Override
    public void validatePurchaseAmount(int ticketPurchaseAmount) {
        if (ticketPurchaseAmount <= 0) {
            throw new IllegalArgumentException("로또 구입 금액은 0원보다 커야합니다.");
        }
        if (ticketPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 나누어 떨어져야합니다.");
        }
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    @Override
    public int getTicketCount() {
        return lotteryCount;
    }
}
