package lotto.Controller;

import static lotto.Utils.Convert.convertBonusNumberStringToInt;
import static lotto.Utils.Convert.convertInputPurchaseStringToInt;
import static lotto.Utils.Convert.convertStringToList;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoPublication;
import lotto.Domain.LottoWinnings;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {

    public void startLotto() {
        int lottoPurchase = getValidPurchaseInput();
        LottoPublication lottoPublication = new LottoPublication(lottoPurchase);
        OutputView.printLotto(lottoPublication.totalLotto(), lottoPublication.theNumberOfLotto());

        Lotto inputLotto = getValidLottoNumberInput();

        int bonusNumber = getValidBonusInput();
        LottoWinnings lottoWinnings = new LottoWinnings(inputLotto.getNumbers(), bonusNumber,
                lottoPublication.totalLotto());

        OutputView.printWinningStatistics(lottoWinnings.findMatchNumberCount());

        LottoService lottoService = new LottoService(lottoWinnings);
        OutputView.printEarningRate(lottoService.earningRate(lottoPurchase));
    }

    public static int getValidPurchaseInput() {
        while (true) {
            String inputPurchase = InputView.lottoPurchase();

            try {
                return convertInputPurchaseStringToInt(inputPurchase);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    public static int getValidBonusInput() {
        while (true) {
            String inputBonus = InputView.bonusNumber();

            try {
                return convertBonusNumberStringToInt(inputBonus);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }

    public Lotto getValidLottoNumberInput() {

        while (true) {
            String inputLottoNum = InputView.lottoCastLotsLot();

            try {
                List<Integer> numbers = convertStringToList(inputLottoNum);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
    }
}
