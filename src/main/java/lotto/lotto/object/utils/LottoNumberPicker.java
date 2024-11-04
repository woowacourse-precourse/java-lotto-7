package lotto.lotto.object.utils;

import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.constant.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberPicker {

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

    public int createBonusNumber() {
        /**
         * 기존 로또 번호에 있는 수는 아닌지 중복 검사하는 로직 추가 필요
         */
        return Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }
}
