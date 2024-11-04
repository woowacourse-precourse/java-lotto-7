package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        UserInputConverter userInputConverter = new UserInputConverter();

        int cost = userInputConverter.getCost();
        LottoGenerator lottoGenerator = new LottoGenerator(cost);

        List<Integer> userWinningNumbers = userInputConverter.getWinningNumbers();
        int userBonusNumber = userInputConverter.getBonusNumber();
        WinningNumber winningNumber = new WinningNumber(userWinningNumbers, userBonusNumber);

        LottoChecker lottoChecker = new LottoChecker(winningNumber, lottoGenerator.getLottos());
        LottoService result = new LottoService(lottoChecker.checkAll(), cost);

        result.printResult();
    }
}
