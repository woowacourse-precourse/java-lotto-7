package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumber;
import lotto.error.LottoError;
import lotto.io.InputHandler;

class InputController {
    private final InputHandler inputHandler;
    private final OutputController outputController;

    public InputController(InputHandler inputHandler, OutputController outputController) {
        this.inputHandler = inputHandler;
        this.outputController = outputController;
    }

    public String getPrice() {
        while (true) {
            String priceInput = inputHandler.price();
            try {
                return validatePrice(priceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumber getWinningNumber() {
        outputController.showWinningNumbersMessage();
        List<Integer> winNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winNumbers);
        return new WinningNumber(winNumbers, bonusNumber);
    }

    private String validatePrice(String priceInput) {
        if (!priceInput.matches("\\d+")) {
            throw new IllegalArgumentException(LottoError.INVALID_PRICE_FORMAT.getMessage());
        }

        int price = Integer.parseInt(priceInput);
        if (price < 1000) {
            throw new IllegalArgumentException(LottoError.INVALID_PRICE_RANGE.getMessage());
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(LottoError.INVALID_PRICE_UNIT.getMessage());
        }

        return priceInput;
    }

    private int getValidBonusNumber(List<Integer> winNumbers) {
        while (true) {
            outputController.showBonusNumberMessage();
            String bonusInput = inputHandler.bonusNumber();
            try {
                int bonusNumber = validateBonusNumber(bonusInput, winNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            String winningInput = inputHandler.winningNumbers();
            try {
                return validateWinningNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                outputController.showWinningNumbersMessage();
            }
        }
    }

    private List<Integer> validateWinningNumbers(String winningInput) {
        if (!winningInput.matches("(\\d+)(,\\s*\\d+)*")) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_DELIMITER.getMessage());
        }

        String[] parts = winningInput.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }

        return parseWinningNumbers(parts);
    }

    private List<Integer> parseWinningNumbers(String[] parts) {
        List<Integer> winNumbers = new ArrayList<>();
        for (String part : parts) {
            int number = parseWinningNumber(part.trim());
            winNumbers.add(number);
        }
        return winNumbers;
    }

    private int parseWinningNumber(String part) {
        try {
            int number = Integer.parseInt(part);
            validateWinningNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private void validateWinningNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private int validateBonusNumber(String bonusInput, List<Integer> winNumbers) {
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER2.getMessage());
        }

        try {
            int bonusNumber = Integer.parseInt(bonusInput.trim());
            validateBonusNumberRange(bonusNumber, winNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber, List<Integer> winNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoError.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
