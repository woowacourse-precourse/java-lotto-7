package lotto.mvc.controller;

import static lotto.util.Constants.DELIMITER;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.mvc.model.Lotto;
import lotto.mvc.view.InputView;
import lotto.validation.LottoBonusNumberValidator;
import lotto.validation.LottoNumberValidator;
import lotto.validation.PurchaseAmountValidator;

public class InputHandler {
    private static final String REPLACEMENT_OF_DELIMITER = "";
    private InputView inputView = new InputView();

    public long getPurchaseAmount() {
        return doLoop(() -> {
            inputView.showPurchaseAmountMsg();

            String purchaseAmount = inputView.getUserInput();
            purchaseAmount = trimInput(purchaseAmount);
            purchaseAmount = removeDelimiter(purchaseAmount);

            PurchaseAmountValidator.isValid(purchaseAmount);

            return Long.parseLong(purchaseAmount);
        });
    }

    public List<Integer> getLottoWinningNumbers() {
        return doLoop(() -> {
            inputView.showLottoWinningNumberMsg();
            String winningNumber = inputView.getUserInput();
            winningNumber = trimInput(winningNumber);

            LottoNumberValidator.isValid(winningNumber);

            return extractLottoNumber(winningNumber);
        });
    }

    public int getLottoBonusNumber(Lotto winningLotto) {
        return doLoop(() -> {
            inputView.showLottoBonusNumberMsg();
            String bonusNumber = inputView.getUserInput();
            bonusNumber = trimInput(bonusNumber);

            LottoBonusNumberValidator.isValid(winningLotto, bonusNumber);

            return Integer.parseInt(bonusNumber);
        });
    }

    private <T> T doLoop(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String trimInput(String input) {
        return input.trim();
    }

    private String removeDelimiter(String input) {
        String refinedInput = input.replaceAll(DELIMITER, REPLACEMENT_OF_DELIMITER);

        if (input.endsWith(DELIMITER)) {
            refinedInput += DELIMITER;
        }

        return refinedInput;
    }

    private List<Integer> extractLottoNumber(String winningNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : winningNumber.split(DELIMITER)) {
            number = trimInput(number);
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
