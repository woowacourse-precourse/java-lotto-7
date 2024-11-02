package view;

import java.util.Set;
import lotto.Lotto;

public class OutputView {

    public static String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static String MESSAGE_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    public static String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println("\n" + purchaseQuantity + "개를 구매했습니다.");
    }

    public void printLottos(Set<Lotto> lottos) {
        lottos.stream()
              .map(Lotto::getNumbers)
              .forEach(System.out::println);
    }
}
