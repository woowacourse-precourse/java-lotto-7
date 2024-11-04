package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static int strToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static String[] separateStr(String input, String separator) {
        return input.split(separator);
    }

    public static boolean isContainInRange(String numStr) {
        return Integer.parseInt(numStr) >= MIN_LOTTO_NUMBER && Integer.parseInt(numStr) <= MAX_LOTTO_NUMBER;
    }

    public static List<Integer> getRandomNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
