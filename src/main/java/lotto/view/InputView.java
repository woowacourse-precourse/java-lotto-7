package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static long inputNumber(String message) {
        System.out.println(message);
        String input = Console.readLine();
        validate(input);
        return Long.parseLong(input);
    }

    private static void validate(String input){
        validateEmpty(input);
        validateNumeric(input);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateNumeric(String inputValue) {
        try {
            long amount = Long.parseLong(inputValue);
            validateNegative(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자 형식이 아닙니다.");
        }
    }

    private static void validateNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(" 음수는 입력할 수 없습니다.");
        }
    }


    public static List<Integer> inputWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningLottoInput = Console.readLine();
        validateEmpty(winningLottoInput);
        validateCommaFormat(winningLottoInput);
        return convertToNumbers(winningLottoInput);
    }

    private static List<Integer> convertToNumbers(String input) {
        List<String> numberStrings = splitInputByComma(input);
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            numbers.add(Integer.parseInt(numberStr.trim()));
        }
        return numbers;
    }

    private static void validateCommaFormat(String input) {
        List<String> numbers = splitInputByComma(input);
        validateNumberFormat(numbers);
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static void validateNumberFormat(List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number.trim());
        }
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자만 입력 가능합니다.");
        }
    }


}
