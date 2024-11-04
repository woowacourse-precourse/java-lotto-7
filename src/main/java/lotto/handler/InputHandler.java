package lotto.handler;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.util.Converter;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PriceValidator;
import lotto.validation.WinningNumberValidator;
import lotto.view.InputView;

public class InputHandler {

    public static PurchasePrice receiveValidatedPurchasePrice() {
        return inputWithValidation(
                InputView::inputPurchasePrice,
                input -> {
                    PriceValidator.validatePrice(input);
                    return null;
                },
                PurchasePrice::new
        );
    }

    public static WinningNumber receiveValidatedWinningNumber() {
        return inputWithValidation(
                InputView::inputWinningNumber,
                input -> {
                    WinningNumberValidator.validateWinningNumber(input);
                    return null;
                },
                input -> new WinningNumber(Converter.convertStringToIntegerList(input))
        );
    }

    public static BonusNumber receiveValidatedBonusNumber(WinningNumber winningNumber) {
        return inputWithValidation(
                InputView::inputBonusNumber,
                input -> {
                    BonusNumberValidator.validateBonusNumber(input);
                    return null;
                },
                input -> {
                    int convertInput = Converter.convertStringToInt(input);
                    BonusNumberValidator.validateConvertBonusNumber(convertInput, winningNumber);
                    return new BonusNumber(convertInput, winningNumber);
                }
        );
    }

    private static <T> T inputWithValidation(Supplier<String> inputSupplier, Function<String, Void> validator,
                                             Function<String, T> creator) {
        while (true) {
            try {
                String input = inputSupplier.get();
                validator.apply(input);
                return creator.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
