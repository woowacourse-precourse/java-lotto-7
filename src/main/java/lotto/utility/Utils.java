package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    public static void checkEmptyInput(String userInputcarsName) {
        if (userInputcarsName.isEmpty()) throw new IllegalArgumentException
                (ExceptionMessages.EMPTY_EXCEPTION_MESSAGE.getMessage());
        if (userInputcarsName == null) throw new IllegalArgumentException
                (ExceptionMessages.NULL_EXCEPTION_MESSAGE.getMessage());
    }

    public static List<Integer> getRandomNumbers(int minNum, int maxNum, int numCount) {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(minNum, maxNum, numCount));
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }
}
