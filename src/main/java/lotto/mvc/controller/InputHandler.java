package lotto.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.mvc.model.Lotto;
import lotto.mvc.validation.LottoBonusNumberValidator;
import lotto.mvc.validation.LottoNumberValidator;
import lotto.mvc.validation.PurchaseAmountValidator;
import lotto.mvc.view.InputView;

public class InputHandler {
    private static final String DELIMITER = ",";
    private static final String REPLACEMENT_OF_DELIMITER = "";
    private InputView inputView = new InputView();

    public long getPurchaseAmount() {
        while (true) {
            try {
                inputView.showPurchaseAmountMsg();

                String purchaseAmount = inputView.getUserInput();
                purchaseAmount = trimInput(purchaseAmount);
                purchaseAmount = removeDelimiter(purchaseAmount);

                PurchaseAmountValidator.isValid(purchaseAmount);

                return Long.parseLong(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getLottoWinningNumbers() {
        while (true) {
            try {
                inputView.showLottoWinningNumberMsg();
                String winningNumber = inputView.getUserInput();
                winningNumber = trimInput(winningNumber);

                LottoNumberValidator.isValid(winningNumber);

                return extractLottoNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getLottoBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                inputView.showLottoBonusNumberMsg();
                String bonusNumber = inputView.getUserInput();
                bonusNumber = trimInput(bonusNumber);

                LottoBonusNumberValidator.isValid(winningLotto, bonusNumber);

                return Integer.parseInt(bonusNumber);
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
