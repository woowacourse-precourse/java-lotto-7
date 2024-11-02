package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;

    public int getRandomNumber() {
        int randomnumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomnumber;
    }
}
