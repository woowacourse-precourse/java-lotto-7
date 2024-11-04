package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    // 정수인지 확인
    public static void isNumeric(String input) {
        if (input == null || !input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력 값 내에 정수 외의 값이 있습니다.");
        }
    }

    // 정수 및 , 인지 확인
    public static void isNumericWithCommas(String input) {
        if (input == null || !input.matches("[\\d,]+")) {
            throw new IllegalArgumentException("[ERROR] 입력 값 내에 정수나 , 외의 값이 있습니다.");
        }
    }

    // 단위 확인
    public static void isClearedByNum(String input, int num) {
        if ((Integer.parseInt(input) % num) != 0) {
            throw new IllegalArgumentException("[ERROR] " + num + "단위의 값만 입력이 가능합니다.");
        }
    }

    // 입력값이 min 이상, max 미만인지 확인하는
    public static void checkOverThanMinAndLessThanMax(int i, int min, int max) {
        if (!(i >= min && i <= max)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 " + min + "과 " + max + " 사이여야 합니다.");
        }
    }

    public static void checkInputIsNotInNumbers(List<Integer> numbers, String input, String numbersName) {
        for (int i : numbers) {
            if (i == Integer.parseInt(input)) {
                throw new IllegalArgumentException("[ERROR] 해당 값이 " + numbersName + " 내에 존재하면 안됩니다.");
            }
        }
    }

    // 문자열 , 기준으로 쪼개기
    public static List<Integer> splitByComma(String input) {
        List<Integer> numbersList = new ArrayList<>();

        if (input != null && !input.isEmpty()) {
            String[] parts = input.split(",");
            for (String part : parts) {
                numbersList.add(Integer.parseInt(part.trim()));
            }
        }

        return numbersList;
    }

}
