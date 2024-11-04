package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {
    private static LottoController controller = new LottoController();
    public static void main(String[] args) {
        String inputPurchaseStr = InputView.inputLottoPurchase();
        int lottoCount = controller.getLottoCount(inputPurchaseStr);

        ArrayList<Lotto> lottos = controller.createLottos(lottoCount);

        OutputView.printLottoNumbers(lottoCount, lottos);

        String inputNumbersStr = InputView.inputLottoNumber();
        String inputBonusNumberStr = InputView.inputBunusNumber();

        ArrayList<Integer> lottoWinningNumbers = controller.getWinningNumber(inputNumbersStr);
        int lottoBonusNumber = controller.getBonnusNumber(inputBonusNumberStr);

        LottoResult lottoResult = controller.getResultLotto(lottos, lottoWinningNumbers, lottoBonusNumber);

        String totalWinnings = controller.getTotalWinnings(lottoCount, lottoResult);

        OutputView.printLottoResult(lottoResult.toString(), totalWinnings);
    }
}
