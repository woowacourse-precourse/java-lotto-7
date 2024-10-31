package validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final String BLANK_INPUT_ERROR = "[ERROR] 비어있는 문자열입니다.";
    private static final String INVALID_INPUT_ERROR = "[ERROR] 정상적인 입력이 아닙니다.";
    private static final String OVER_INPUT_ERROR = "[ERROR] 회차당 10만원을 초과할 수 없습니다.";
    private static final String NUM_RANGE_ERROR = "[ERROR] 번호의 범위는 1 ~ 45여야 합니다.";
    private static final int MAX_MONEY = 100000;
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;

    public static void blankInput(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR);
        }
    }

    public static void numberInput(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        if (num <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }

    }

    public static void overInput(int inputMoney) {
        if (inputMoney > MAX_MONEY) {
            throw new IllegalArgumentException(OVER_INPUT_ERROR);
        }
    }

    public static <T> void duplicate(List<T> input){
        Set<T> hashSet = new HashSet<>();
        hashSet.addAll(input);
        if(hashSet.size() != input.size())
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
    }

    public static void range(int inputNum){
        if(inputNum < LOTTO_NUM_START || inputNum > LOTTO_NUM_END)
            throw new IllegalArgumentException(NUM_RANGE_ERROR);
    }

}

