package lotto.logic;

import static lotto.output.Output.generateLottosOutput;
import static lotto.output.Output.purchaseCountOutput;
import static lotto.output.Output.resultOutput;

import camp.nextstep.edu.missionutils.Console;
import lotto.input.Bonus;
import lotto.input.Input;
import lotto.input.Lotto;
import lotto.input.Purchase;

public class LottoGame {

    private static Purchase purchase;
    private static Lotto winningNumber;
    private static Bonus bonus;
    private static LottoNumbersGenerator lottoNumbersGenerator;

    public static void game() {
        startGame();
        winningLotto();
        endGame();
        Console.close();
    }

    private static void startGame() {
        purchase = Input.getPurchaseAmount();
        purchaseCountOutput(purchase);
        lottoNumbersGenerator = new LottoNumbersGenerator(purchase.getCount());
        generateLottosOutput(lottoNumbersGenerator);
    }

    private static void winningLotto() {
        winningNumber = Input.getWinningNumbers();
        bonus = Input.getBonusNumber(winningNumber);
    }

    private static void endGame() {
        LottoResultEvaluator lottoResultEvaluator = new LottoResultEvaluator();
        lottoResultEvaluator.evaluateLottoResults(winningNumber, lottoNumbersGenerator, bonus, purchase);
        resultOutput(lottoResultEvaluator);
    }
}
