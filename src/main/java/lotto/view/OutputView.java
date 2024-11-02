package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    public void showMoneyInputComments() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoWinningNumbersInputComments() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showLottoBonusNumberInputComments() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showPurchasedLottos(int purchasedCount, Lottos purchasedLottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다\n", purchasedCount);
        List<Lotto> lottos = purchasedLottos.getLottos();

        lottos.forEach(System.out::println);
        System.out.println();
    }
}
