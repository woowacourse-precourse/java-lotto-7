package lotto.controller;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseValidator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class InputRetryUtil {
    final private ConsoleInput consoleInput;
    final private ConsoleOutput consoleOutput;

    public InputRetryUtil(ConsoleInput consoleInput, ConsoleOutput consoleOutput) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
    }

    public int getValidatedPurchaseAmount() {
        return readValidatedInput(consoleInput::getPurchasedAmount, InputParser::parseInteger,
                PurchaseValidator::validate);
    }

    public List<Integer> getValidatedWinningNumbers() {
        return readValidatedInput(consoleInput::getWinningNumbers, InputParser::parseIntegers,
                LottoValidator::validate);
    }

    public int getValidatedBonusNumber(List<Integer> winningNumbers) {
        return readValidatedInput(consoleInput::getBonusNumber, InputParser::parseInteger,
                bonusNumber -> WinningNumbersValidator.bonusNumber(winningNumbers, bonusNumber));
    }

    private <T> T readValidatedInput(Supplier<String> inputSupplier, Function<String, T> parser,
                                     Consumer<T> validator) {
        while (true) {
            try {
                String userInput = inputSupplier.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
                consoleOutput.printException(error);
            }
        }
    }
}
