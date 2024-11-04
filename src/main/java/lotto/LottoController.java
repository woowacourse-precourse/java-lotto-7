package lotto;

import static lotto.constant.PrintMessageConstants.INPUT_BONUS_NUMBER;
import static lotto.constant.PrintMessageConstants.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.PrintMessageConstants.INPUT_WINNING_NUMBERS;
import static lotto.constant.PrintMessageConstants.PRINT_RESULT;

import java.util.List;
import java.util.Map;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoShop;
import lotto.lotto.object.MyLotto;
import lotto.lotto.object.WinningLotto;
import lotto.validation.LottoNumberValidation;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoShop lottoShop;
    private final LottoNumberValidation lottoNumberValidation;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, LottoShop lottoShop,
                           LottoNumberValidation lottoNumberValidation) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoShop = lottoShop;
        this.lottoNumberValidation = lottoNumberValidation;
    }

    public void run() {
        boolean flag = true;
        // 구매 금액 입력
        outputHandler.printPrompt(INPUT_PURCHASE_AMOUNT);
        long money = 0;
        while (flag) {
            try {
                money = inputHandler.inputMoney();
                flag = false;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
        outputHandler.printLineBreak();

        // 로또 구매
        List<MyLotto> myLottos = lottoShop.buyLottos(money);
        outputHandler.printPurchasedLotto(myLottos);
        outputHandler.printLineBreak();

        // 당첨 번호 입력
        outputHandler.printPrompt(INPUT_WINNING_NUMBERS);
        WinningLotto winningLotto = null;
        flag = true;
        while (flag) {
            try {
                List<Integer> numbers = inputHandler.inputWinningNumbers();
                winningLotto = new WinningLotto(numbers, lottoNumberValidation);
                flag = false;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
        outputHandler.printLineBreak();

        // 보너스 번호 입력
        outputHandler.printPrompt(INPUT_BONUS_NUMBER);
        flag = true;
        int bonusNumber = 0;
        while (flag) {
            try {
                bonusNumber = inputHandler.inputBonusNumber();
                winningLotto.setBonusNumber(bonusNumber);
                flag = false;
            } catch (IllegalArgumentException e) {
                outputHandler.printErrorMessage(e.getMessage());
            }
        }
        outputHandler.printLineBreak();

        // 각 복권 별로 순위 매기기
        LottoResult lottoResult = new LottoResult(winningLotto);
        for (MyLotto myLotto : myLottos) {
            int rank = lottoResult.assignRank(myLotto);
            myLotto.setRank(rank);
        }

        // 당첨 통계 출력
        outputHandler.printPrompt(PRINT_RESULT);
        Map<Integer, Integer> winningStatistics = lottoResult.winnerLottoCount(myLottos);
        outputHandler.printResult(winningStatistics);

        // 수익률 출력
        double returnRate = lottoResult.getReturnRate(money, myLottos);
        outputHandler.printReturnRate(returnRate);
    }
}
