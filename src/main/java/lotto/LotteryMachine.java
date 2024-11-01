package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LotteryMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void purchaseLottoTickets(Bag bag) {
        int purchaseAmount = bag.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
        int numberOfPurchase = purchaseAmount/LOTTO_TICKET_PRICE;
        IntStream.range(0,numberOfPurchase).forEach(i -> purchaseLotto(bag));
    }

    private void purchaseLotto(Bag bag) {
        List<Integer> pickedNumbers = pickNumbersSorted();
        Lotto lotto = new Lotto(pickedNumbers);
        bag.buyLotto(lotto);
    }
    private List<Integer> pickNumbersSorted() {
        List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        pickNumbers.sort(Comparator.naturalOrder());
        return pickNumbers;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount%LOTTO_TICKET_PRICE!=0)
            throw new IllegalArgumentException("[ERROR] 구매금액은 로또가격단위여야합니다.");
    }
}
