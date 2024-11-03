package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.checker.WinningChecker;
import lotto.config.constant.LottoPurchaseConstant;
import lotto.config.enumerate.WinningInfo;
import lotto.generator.LottoGenerator;
import lotto.parser.UserInputParser;
import lotto.printer.ResultPrinter;

public class Application {
    public static void main(String[] args) {

        UserInputParser userInputParser = new UserInputParser();
        LottoGenerator lottoGenerator = new LottoGenerator();
        WinningChecker winningChecker;

        System.out.println("구입 금액을 입력해 주세요.");
        String lottoPurchaseAmountInput = Console.readLine();
        long lottoPurchaseAmount = userInputParser.getLottoPurchaseAmount(lottoPurchaseAmountInput);

        List<Lotto> lottoes = lottoGenerator.generate(lottoPurchaseAmount / LottoPurchaseConstant.AMOUNT_UNIT);
        ResultPrinter.printLottoesBought(lottoes);

        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoWinningNumbersInput = Console.readLine();
        int[] winningNumbers = userInputParser.getLottoWinningNumbers(lottoWinningNumbersInput);

        System.out.println("보너스 번호를 입력해 주세요.");
        String winningBonusNumberInput = Console.readLine();
        int bonusNumber = userInputParser.getLottoWinningBonusNumber(winningBonusNumberInput);

        winningChecker = new WinningChecker(winningNumbers, bonusNumber);
        Map<WinningInfo, Integer> winningResult = winningChecker.getWinningResult(lottoes);

        //ResultPrinter.printWinningResult(winningResult);

    }
}
