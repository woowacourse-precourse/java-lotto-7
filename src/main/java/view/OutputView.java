package view;

import domain.LottoResult;
import lotto.Lotto;

import java.util.List;

public class OutputView {
    Messages messages;

    public void printPurchaseMsg(LottoResult result) {
        System.out.println(result.getTotalLottos() + messages.AMOUNT_PURCHASE_MSG.getMessage());
        List<Lotto> purchasedLottos = result.getPurchasedLottos();
    }

    public void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(numbers.size() - 1) + "]");
    }
}
