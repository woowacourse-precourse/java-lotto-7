package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputReader inputReader = new InputReader(inputValidator);

        int givenAmount = inputReader.readAmount();
        LottoGenerator lottoGenerator = new LottoGenerator(givenAmount);

        List<Integer> winningNumbers = inputReader.readWinningNumbers();
        int bonusNumber = inputReader.readBonusNumber();

        Results results = new Results(givenAmount, lottoGenerator.getLottoList(),
                winningNumbers, bonusNumber);
        results.printResults();
    }
}
