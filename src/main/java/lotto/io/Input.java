package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorCode;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Input {
    private static final Pattern isWinningNumberPattern = Pattern.compile("^(0?[1-9]|[1-3][0-9]|4[0-5])(,(0?[1-9]|[1-3][0-9]|4[0-5])){5}$");
    private static final String COMMA = ",";
    private final Integer price;
    private final Lotto winningNumber;
    private final Integer bonusNumber;

    public Input() {
        this.price = Integer.parseInt(inputPrice());
        this.winningNumber = inputWinningNumber();
        this.bonusNumber = Integer.parseInt(inputBonusNumber());
    }

    public Integer getPrice() {
        return price;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private String inputPrice() {
        while (true) {
            View.printInputPrice();
            String price = Console.readLine();
            try {
                validatePrice(price);
                return price;
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }
        }
    }

    private Lotto inputWinningNumber() {
        while (true) {
            View.printInputWinningNumber();
            String winningNumber = Console.readLine();
            try {
                validateWinningNumber(winningNumber);
                return Lotto.generateWinningNumber(winningNumber, COMMA);
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }
        }
    }

    private String inputBonusNumber() {
        while (true) {
            View.printInputBonusNumber();
            String bonusNumber = Console.readLine();
            try {
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }
        }
    }

    private void validatePrice(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        validatePriceDivisible(input);
    }

    private void validateWinningNumber(String input) throws IllegalArgumentException {
        validateWinningNumberRightFormat(input);
        validateWinningNumberDuplicate(input);
    }

    private void validateBonusNumber(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        validateBonusNumberInRange(input);
        validateBonusNumberDuplicate(input);
    }

    private void validateInputNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.PRICE_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private void validatePriceDivisible(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new NumberFormatException(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
        }
    }

    private void validateWinningNumberRightFormat(String input) {
        if (!isWinningNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage());
        }
    }

    private void validateWinningNumberDuplicate(String input) {
        List<Integer> numbers = Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage());
        }
    }


    private void validateBonusNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage());
        }
    }

    private void validateBonusNumberDuplicate(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

}
