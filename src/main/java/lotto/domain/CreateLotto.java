package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import java.util.List;

public class CreateLotto {

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
            LottoConstant.LOTTO_MIN_NUM.getValue(),
            LottoConstant.LOTTO_MAX_NUM.getValue(),
            LottoConstant.LOTTO_SIZE.getValue()
        );
    }
}