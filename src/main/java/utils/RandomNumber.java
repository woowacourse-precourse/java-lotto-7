package utils;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private RandomNumber() {

    }

    public static List<Integer> create() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != LOTTO_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            verifyDuplicateRandomNumber(randomNumbers, randomNumber);
            Collections.sort(randomNumbers);
        }
        return Collections.unmodifiableList(randomNumbers);
    }

    private static void verifyDuplicateRandomNumber(List<Integer> randomNumbers, int randomNumber) {
        if (randomNumbers.contains(randomNumber)) {
            return;
        }
        randomNumbers.add(randomNumber);
    }
}
