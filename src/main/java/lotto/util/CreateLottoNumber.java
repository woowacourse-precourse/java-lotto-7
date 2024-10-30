package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLottoNumber;

import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PICK_NUMBER_SIZE = 6;

    private static List<Integer> createNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_PICK_NUMBER_SIZE);
    }

    private static List<Integer> sortNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public static UserLottoNumber createLotto() {
        return new UserLottoNumber(sortNumber(createNumber()));
    }
}
