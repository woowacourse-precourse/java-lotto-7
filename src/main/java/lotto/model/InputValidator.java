package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    public static final String EMPTY_INPUT_EXCEPTION = "[ERROR] 입력된 금액이 없습니다.";
    public static final String INVALID_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구입 금액 입력은 숫자(양의 정수)로만 이루어져야 합니다.";
    public static final String UNDER_MIN_AMOUNT_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 최소 한장 이상 구매할 수 있는 금액을 입력하셔야 합니다. (한장 1000)";
    public static final String INVALID_AMOUNT_UNIT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액은 1000원 단위로 입력하셔야 합니다. (1000으로 나누어 떨어지도록)";
    public static final String EXCEED_MAX_AREA_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액이 최대 범위를 초과하였습니다.";

    public static final String NUMBER_DUPLICATION_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호는 중복 될 수 없습니다.";
    public static final String NUMBER_AREA_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호는 1~45까지의 숫자만 가능합니다.";
    public static final String INVALID_WINNING_NUMBER_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호 입력은 숫자와 구분자(,)로만 이루어져야 합니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 당첨 번호 입력의 시작과 끝은 숫자로 이루어져야 합니다.";
    public static final String INVALID_SEPARATOR_NUMBER_EXCEPTION = "[ERROR] 잘못된 당첨 번호를 입력하셨습니다."
            + " 구분자 사이에 반드시 숫자가 존재해야 합니다.";

    private static final String AMOUNT_PATTERN_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_PATTERN_REGEX = "^[0-9,]+$";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String SEPARATOR = ",";
    private static final String INVALID_SEPARATOR_PATTERN = ",,";

    public void validateInputAmount(String input) {
        validateEmptyOf(input);
        validateInvalidCharacterOf(input);
        int amount = validateExceedMaxAreaOf(input);
        validateMinAmountOf(amount);
        validateAmountUnitOf(amount);
    }

    private void validateEmptyOf(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
    }

    private void validateInvalidCharacterOf(String input) {
        if (!Pattern.matches(AMOUNT_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_INPUT_EXCEPTION);
        }
    }

    private int validateExceedMaxAreaOf(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEED_MAX_AREA_EXCEPTION);
        }
    }

    private void validateMinAmountOf(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
        }
    }

    private void validateAmountUnitOf(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_EXCEPTION);
        }
    }

    public List<Integer> validateInputWinningNumber(String input) {
        validateEmptyOf(input);
        validateWinningNumberCharacterOf(input);
        validateFormatOf(input);
        validateSeparatedNumberOf(input);
        return createNumbers(input);
    }

    private List<Integer> createNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> forValidateDuplication = new HashSet<>();
        for (String separatedInput : input.split(SEPARATOR)) {
            int number = Integer.parseInt(separatedInput);
            validateNumberAreaOf(number);
            validateNumberDuplication(forValidateDuplication, number);
            numbers.add(number);
        }
        return numbers;
    }

    private void validateWinningNumberCharacterOf(String input) {
        if (!Pattern.matches(WINNING_NUMBER_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_CHARACTER_INPUT_EXCEPTION);
        }
    }

    private void validateFormatOf(String input) {
        if (input.endsWith(",") || input.startsWith(",")) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT_EXCEPTION);
        }
    }

    private void validateSeparatedNumberOf(String input) {
        if (input.contains(INVALID_SEPARATOR_PATTERN)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_NUMBER_EXCEPTION);
        }
    }

    private void validateNumberAreaOf(int number) {
        boolean isInValidNumberArea = number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
        if (isInValidNumberArea) {
            throw new IllegalArgumentException(NUMBER_AREA_EXCEPTION);
        }
    }

    private void validateNumberDuplication(Set<Integer> forValidateDuplication, int number) {
        boolean isDuplicated = !forValidateDuplication.add(number);
        if (isDuplicated) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION);
        }
    }

}
