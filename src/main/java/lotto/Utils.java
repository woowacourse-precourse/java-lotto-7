package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;
    public static final int COST_UNIT = 1000;

    public static int strToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String[] separateStr(String input, String separator) {
        return input.split(separator);
    }

    public static boolean isContainInRange(String numStr, int minValue, int maxValue) {
        return Integer.parseInt(numStr) >= minValue && Integer.parseInt(numStr) <= maxValue;
    }

    public static List<Integer> getRandomNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
