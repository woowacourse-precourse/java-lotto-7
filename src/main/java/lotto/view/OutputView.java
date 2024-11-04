package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class OutputView {

    public static void requestInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void requestInputBounusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void outputAutoLottos(List<Lotto> lottos) {
        System.out.println(String.format("\n%d개를 구매했습니다.", lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void outputWinningResult(WinningResult lottoResult, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(lottoResult);
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.calculateRateOfReturn(purchaseAmount));
    }
}
