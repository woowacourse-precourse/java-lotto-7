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

// 사용자로부터 로또 관련 입력을 처리하고 검증하는 클래스
public class LottoInputHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoInputHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
                bonusNumber -> {
                    LottoValidator.validateBonusNumberRange(bonusNumber);
                    LottoValidator.validateBonusNumberDuplication(bonusNumber, winningNumbers);
                }
        );
    }

    private <T> T getValidatedInput(Supplier<String> inputSupplier,
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

    private void validateLottoNumbers(List<Integer> numbers) {
        new Lotto(numbers); // Lotto 생성자를 통한 검증 수행
    }

    public void close() {
        inputView.close();
    }

}
