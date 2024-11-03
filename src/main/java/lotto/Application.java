package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {
    private static LottoController controller = new LottoController();
    public static void main(String[] args) {
        String inputPurchaseStr = InputView.inputLottoPurchase();
        int lottoPurchase = controller.getLottoPurchaseInt(inputPurchaseStr);

        int lottoCount = controller.getLottoCount();
        ArrayList<Lotto> lottos = controller.getLottos();

        OutputView.printLottoNumbers(lottoCount, lottos);

        String inputNumbersStr = InputView.inputLottoNumber();
        String inputBonusNumberStr = InputView.inputBunusNumber();
        LottoResult lottoResult = controller.getResultLotto(inputNumbersStr, inputBonusNumberStr, lottos);

        String totalWinnings = controller.getTotalWinnings(lottoPurchase, lottoResult);

        OutputView.printLottoResult(lottoResult.toString(), totalWinnings);
    }
}
