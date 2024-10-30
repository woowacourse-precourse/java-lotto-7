package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.println("\n" + purchasedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }
}
