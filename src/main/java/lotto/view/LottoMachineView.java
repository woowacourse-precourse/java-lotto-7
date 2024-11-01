package lotto.view;

import lotto.model.Lotto;
import lotto.model.PurchasedLottos;

public class LottoMachineView {
    public static void printPurchaseLottoView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedLottosView(PurchasedLottos purchasedLottos) {
        System.out.println(purchasedLottos.getSize() + "개를 구매했습니다.");

        StringBuilder purchasedLottoNumbers = new StringBuilder();
        for ( Lotto lotto : purchasedLottos ) {
            purchasedLottoNumbers.append(lotto.getNumbers().toString()).append('\n');
        }

        System.out.println(purchasedLottoNumbers);
    }

    public static void printEnterWinningNumbersView() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusWinningNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public static void printStatisticsView() {

    }
}
