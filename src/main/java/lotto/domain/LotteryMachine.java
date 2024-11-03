package lotto.domain;

import lotto.dto.Lotto;
import lotto.dto.Result;
import lotto.util.LottoRank;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LotteryMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void purchaseLottoTickets(User user) {
        int purchaseAmount = user.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
        int numberOfPurchase = purchaseAmount/LOTTO_TICKET_PRICE;
        IntStream.range(0,numberOfPurchase).forEach(i -> purchaseLotto(user));
    }

    private void purchaseLotto(User user) {
        List<Integer> pickedNumbers = user.pickNumbersSorted();
        Lotto lotto = new Lotto(pickedNumbers);
        user.buyLotto(lotto);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount%LOTTO_TICKET_PRICE!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액은 로또가격단위여야합니다.");
    }
}
