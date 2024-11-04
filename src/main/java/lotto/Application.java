package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView outputView = new OutputView();
        LottoController controller = new LottoController();

        // 로또 구매
        PurchaseAmount purchaseAmount = controller.buyLotto();

        // 로또 발행
        List<Lotto> lottos = controller.issueLotto(purchaseAmount);
        outputView.printLottoNumber(lottos, purchaseAmount.getCanBuyLottoCount());

        // 당첨 번호 발행
        controller.issueWinningNumber();
        BonusNumber bonusNumber = controller.issueBonusNumber();

        // 당첨 결과 계산
        controller.calculateWinning(lottos, bonusNumber);

        outputView.printWinningInformation();
        outputView.printReturnOfRate(controller.calculateRateOfReturn(purchaseAmount));
    }
}
