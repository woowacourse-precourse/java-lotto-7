package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.checker.WinningChecker;
import lotto.config.constant.LottoPurchaseConstant;
import lotto.data.Lotto;
import lotto.data.WinningLotto;
import lotto.data.WinningResult;
import lotto.generator.LottoGenerator;
import lotto.parser.UserInputParser;
import lotto.printer.ResultPrinter;

public class Application {
    public static void main(String[] args) {

        try {

            UserInputParser userInputParser = new UserInputParser();
            LottoGenerator lottoGenerator = new LottoGenerator();
            WinningChecker winningChecker;

            System.out.println("구입 금액을 입력해 주세요.");
            String lottoPurchaseAmountInput = Console.readLine();
            long lottoPurchaseAmount = userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput);

            List<Lotto> lottoes = lottoGenerator.generateLottoes(
                    lottoPurchaseAmount / LottoPurchaseConstant.AMOUNT_UNIT);
            ResultPrinter.printLottoesBought(lottoes);

            System.out.println("당첨 번호를 입력해 주세요.");
            String lottoWinningNumbersInput = Console.readLine();
            List<Integer> winningNumbers = userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput);

            System.out.println("\n보너스 번호를 입력해 주세요.");
            String winningBonusNumberInput = Console.readLine();
            int bonusNumber = userInputParser.getLottoWinningBonusNumber(winningBonusNumberInput);

            WinningLotto winningLotto = lottoGenerator.generateWinningLotto(winningNumbers, bonusNumber);

            winningChecker = new WinningChecker(winningLotto);
            WinningResult winningResult = winningChecker.getWinningResult(lottoPurchaseAmount, lottoes);

            ResultPrinter.printWinningResult(winningResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
