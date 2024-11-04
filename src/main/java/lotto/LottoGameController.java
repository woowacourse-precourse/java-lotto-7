package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        inputView.displayLottoPurchaseAmountPrompt();
        int lottoPurchaseAmount = inputView.readLottoPurchaseAmount();
        Lottos lottos = Lottos.from(lottoGenerator.issue(lottoPurchaseAmount));
        outputView.displayLottoCount(lottos);
        outputView.displayLottoNumbers(lottos);

        inputView.displayWinningNumbersPrompt();
        List<Integer> parsedWinningNumbers = parseWinningNumbers(inputView.readWinningNumbers());
        WinningNumbers winningNumbers = WinningNumbers.from(parsedWinningNumbers);
    }

    private List<Integer> parseWinningNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        String[] userInputNumbers = userInput.split(",", -1);

        for (String userInputNumber : userInputNumbers) {
            int number = parseNumber(userInputNumber.trim());
            numbers.add(number);
        }

        return numbers;
    }

    private int parseNumber(String userInputNumber) {
        return Integer.parseInt(userInputNumber);
    }
}
