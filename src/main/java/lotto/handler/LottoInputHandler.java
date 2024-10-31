package lotto.handler;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.util.ParsingUtils;
import lotto.validator.InputValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoInputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoInputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getPurchaseAmount() {
        return getInputWithValidation(
                inputView::inputPurchaseAmount,
                this::parsePurchaseAmount,
                this::validateAmount
        );
    }

    public List<Integer> getWinningNumbers() {
        return getInputWithValidation(
                inputView::inputLottoNumbers,
                this::parseWinningNumbers,
                this::validateWinningNumbers
        );
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        return getInputWithValidation(
                inputView::inputBonusNumber,
                this::parseBonusNumber,
                bonusNumber -> validateBonusNumber(bonusNumber, winningNumbers)
        );
    }

    private <T> T getInputWithValidation(Supplier<String> inputSupplier,
                                         Function<String, T> parseFunction,
                                         Consumer<T> validationFunction) {
        while (true) {
            try {
                String input = inputSupplier.get();
                InputValidator.validateNotEmpty(input);
                T parsedInput = parseFunction.apply(input);
                validationFunction.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int parsePurchaseAmount(String input) {
        return ParsingUtils.parseStringToInteger(input);
    }

    private List<Integer> parseWinningNumbers(String input) {
        return ParsingUtils.parseStringToIntegerList(input);
    }

    private int parseBonusNumber(String input) {
        return ParsingUtils.parseStringToInteger(input);
    }

    private void validateAmount(int amount) {
        InputValidator.validatePurchaseAmount(amount);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        new Lotto(numbers); // Lotto 생성자에서 자동 검증 수행
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public void close() {
        inputView.close();
    }

}
