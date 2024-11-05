package lotto.handler;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.util.ParsingUtils;
import lotto.validator.BonusNumberValidator;
import lotto.validator.InputValidator;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class LottoInputHandler {
    private final InputView inputView;
    private final ErrorView errorView;

    public LottoInputHandler(InputView inputView, ErrorView errorView) {
        this.inputView = inputView;
        this.errorView = errorView;
    }

    public int getPurchaseAmount() {
        return getValidatedInput(
                inputView::inputPurchaseAmount,
                ParsingUtils::parseStringToInteger,
                InputValidator::validatePurchaseAmount
        );
    }

    public List<Integer> getWinningNumbers() {
        return getValidatedInput(
                inputView::inputLottoNumbers,
                ParsingUtils::parseStringToIntegerList,
                this::validateLottoNumbers
        );
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        return getValidatedInput(
                inputView::inputBonusNumber,
                ParsingUtils::parseStringToInteger,
                bonusNumber -> validateBonusNumber(bonusNumber, winningNumbers)
        );
    }

    private <T> T getValidatedInput(Supplier<String> inputSupplier,
                                    Function<String, T> parseFunction,
                                    Consumer<T> validationFunction) {
        // 입력.파싱,검증을 순차적으로 실행하고 예외 발생 시 오류 메시지 출력 후 재시도
        while (true) {
            try {
                String input = getInputAndValidate(inputSupplier);
                T parsedInput = parseInput(input, parseFunction);
                validateInput(parsedInput, validationFunction);
                return parsedInput;
            } catch (IllegalArgumentException e) {
                errorView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String getInputAndValidate(Supplier<String> inputSupplier) {
        String input = inputSupplier.get();
        validateInputNotEmpty(input);
        return input;
    }

    private <T> T parseInput(String input, Function<String, T> parseFunction) {
        // 입력값을 특정 타입으로 파싱
        return parseFunction.apply(input);
    }

    private <T> void validateInput(T parsedInput, Consumer<T> validationFunction) {
        validationFunction.accept(parsedInput);
    }

    private void validateInputNotEmpty(String input) {
        InputValidator.validateNotEmpty(input);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        new Lotto(numbers); // Lotto 생성자를 통한 검증 수행
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers);
    }

    public void close() {
        inputView.close();
    }

}
