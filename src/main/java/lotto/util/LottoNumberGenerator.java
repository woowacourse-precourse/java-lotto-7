package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Constant.*;

public class LottoNumberGenerator {

    /**
     * 1~45까지의 랜덤 번호를 오름차순으로 정렬해주는 메서드
     * @return 오름차순으로 정렬된 로또 번호
     */
    public static List<Integer> lottoNumbers() {
        List<Integer> tempNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, REQUIRED_NUMBER_SIZE));
        Collections.sort(tempNumbers);
        return tempNumbers;
    }
}
