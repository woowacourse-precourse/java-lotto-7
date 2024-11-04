package lotto.function.winning.register.processor;

import java.util.List;
import lotto.domain.Lotto;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;

public class WinningLottoNumbersInputProcessor {

    private final String INPUT_LOTTO_NUMBERS_DELIMITER = ",";

    private final PromptPrinter promptPrinter;
    private final Input input;

    public WinningLottoNumbersInputProcessor(PromptPrinter promptPrinter, Input input) {
        this.promptPrinter = promptPrinter;
        this.input = input;
    }

    public Lotto inputWinningLottoNumbers() {
        promptPrinter.printInputLottoWinningNumbers();
        List<Integer> winningNumbers = input.readLineToNumbersWithDelimiter(
                INPUT_LOTTO_NUMBERS_DELIMITER);
        return new Lotto(winningNumbers);
    }


}
