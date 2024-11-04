package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Messages.ErrorMessage;
import lotto.Utils.LottoConstants;
import lotto.Utils.Parser;
import lotto.Utils.Validator;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private Lotto mainNumbers;
    private int bonusNumber;

    private WinningNumbers() {
    }

    public static WinningNumbers create() {
        return new WinningNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getMainNumbers() {
        return mainNumbers.getLotto();
    }

    public void registerMainNumbers(String userInput) {
        validateMainNumbersInput(userInput);

        List<Integer> numbers = Parser.stringToNumberList(userInput);
        validateMainNumbers(numbers);

        this.mainNumbers = Lotto.from(numbers);
    }

    private void validateMainNumbersInput(String userInput) {
        checkEmpty(userInput);
        checkBlank(userInput);
        checkCharacter(userInput);
        checkFormat(userInput);
        checkIntegers(userInput);
    }

    private void checkEmpty(String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MAIN_NUMBERS.getMessage());
        }
    }

    private void checkBlank(String input) {
        if (Validator.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_MAIN_NUMBERS.getMessage());
        }
    }

    private void checkCharacter(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!(Character.isDigit(c) || c == DELIMITER.charAt(0))) {
                String message = String.format(ErrorMessage.CHARACTER_MAIN_NUMBERS.getMessage(), DELIMITER);
                throw new IllegalArgumentException(message);
            }
        }
    }


    private void checkFormat(String input) {
        // split 2번째 파라미터 -1은 "1," -> "1", ""로 나누어줌
        String[] tokens = input.split(DELIMITER, -1);
        for (String token : tokens) {
            if (token.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.FORMAT_MAIN_NUMBERS.getMessage());
            }
        }
    }

    private void checkIntegers(String input) {
        String[] tokens = input.split(DELIMITER);

        for (String token : tokens) {
            if (!Validator.isInteger(token)) {
                String message = String.format(ErrorMessage.RANGE_OUT_NUMBERS.getMessage(),
                        LottoConstants.LOTTO_START_NUMBER,
                        LottoConstants.LOTTO_END_NUMBER);
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void validateMainNumbers(List<Integer> numbers) {
        checkNumbersRange(numbers);
        checkDuplicates(numbers);
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!Validator.inRange(number, LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER)) {
                String message = String.format(ErrorMessage.RANGE_OUT_NUMBERS.getMessage(),
                        LottoConstants.LOTTO_START_NUMBER,
                        LottoConstants.LOTTO_END_NUMBER);
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            // hashSet의 add는 보유하고 있는 값 추가 시 false반환
            if (!set.add(number)) {
                String message = String.format(ErrorMessage.DUPLICATE_NUMBERS.getMessage(), number);
                throw new IllegalArgumentException(message);
            }
        }
    }

    public void registerBonus(String input) {
        validateBonusInput(input);
        int number = Parser.stringToInteger(input);
        validateBonusNumber(number);
        this.bonusNumber = number;
    }

    private void validateBonusInput(String userInput) {
        checkEmpty(userInput);
        checkBlank(userInput);
        checkNumeric(userInput);
        checkIntegers(userInput);
    }

    private void checkNumeric(String input) {
        if (Validator.isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_BONUS_NUMBER.getMessage());
        }
    }

    private void validateBonusNumber(int number) {
        checkNumberRange(number);
        checkBonusDuplicate(number);
    }

    private void checkNumberRange(int number) {
        if (!Validator.inRange(number, LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER)) {
            String message = String.format(ErrorMessage.RANGE_OUT_NUMBERS.getMessage(),
                    LottoConstants.LOTTO_START_NUMBER,
                    LottoConstants.LOTTO_END_NUMBER);
            throw new IllegalArgumentException(message);
        }
    }

    private void checkBonusDuplicate(int number) {
        if (mainNumbers.getNumbers().contains(number)) {
            String message = String.format(ErrorMessage.DUPLICATE_NUMBERS.getMessage(), number);
            throw new IllegalArgumentException(message);
        }
    }

}
