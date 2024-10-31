package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import lotto.controller.LottoController;

public class LottoView {
    private final LottoController controller;

    public LottoView(LottoController controller) {
        this.controller = controller;
    }

    public void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        BigDecimal lottoPrice = controller.readPrice();
        System.out.println();

        int lottoCount = controller.lottoCount(lottoPrice);
        System.out.println(lottoCount + "개를 구매했습니다.");

        controller.allocateLottoNumbers(lottoCount);

        System.out.println(controller.printLottoNumbers() + "\n");

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = controller.inputWinningNumber();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = controller.inputBonusNumber();
        System.out.println();

        controller.confirmWinning(winningNumber, bonusNumber);

        System.out.println("당첨 통계\n---");
        System.out.println(controller.traceWinning());

        System.out.println("총 수익률은 " + controller.getWinningRate(lottoPrice) + "%입니다.");
    }
}
