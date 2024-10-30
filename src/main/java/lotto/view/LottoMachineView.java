package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchasedLottos;

public class LottoMachineView {
    public static void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseLottos(PurchasedLottos purchasedLottos) {
        System.out.println(purchasedLottos.getSize() + "개를 구매했습니다.");

        StringBuilder purchasedLottoNumbers = new StringBuilder();
        for ( Lotto lotto : purchasedLottos ) {
            purchasedLottoNumbers.append(lotto.getNumbers().toString()).append('\n');
        }

        System.out.println(purchasedLottoNumbers);
    }
}
