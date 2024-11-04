package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constants.*;

public class CreateLottoNumber {

    public static UserLotto createLotto() {
        return new UserLotto(sortNumber(createNumber()));
    }

    private static List<Integer> createNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_PICK_NUMBER_SIZE);
    }

    private static List<Integer> sortNumber(List<Integer> numbers) {
        List<Integer> numberList = new ArrayList<>(numbers);
        Collections.sort(numberList);
        return numberList;
    }
}
