package lotto.util;

import lotto.exception.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WinningNumberValidate {

    private static final String SPLIT_DELIMITER = ",";

    public static void validate(String input) {
        List<String> winningNumber = Arrays.stream(input.split(SPLIT_DELIMITER)).map(String::trim).toList();

        checkSize(winningNumber);
        checkDuplicate(winningNumber);
        for (String number : winningNumber) {
            checkType(number);
            checkRange(number);
        }
    }

    // 입력값 개수 검사
    private static void checkSize(List<String> testList) {
        if (testList.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_SIZE.getMessage());
        }
    }

    // 입력값 중복 검사
    private static void checkDuplicate(List<String> testList) {
        Set<String> testSet = Set.copyOf(testList);
        if (testSet.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_DUPLICATE.getMessage());
        }
    }

    // 입력값 자료형 검사
    private static void checkType(String number) {
        String regex = "^[1-9]\\d*$";
        if (!number.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_INT.getMessage());
        }
    }

    // 입력값 범위 검사
    private static void checkRange(String number) {
        int testNumber = Integer.parseInt(number);
        if (testNumber < 1 || testNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.OUT_OF_RANGE.getMessage());
        }
    }

}
