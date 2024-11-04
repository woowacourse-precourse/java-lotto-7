package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class LottoCreator {
    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(),
                LOTTO_NUMBERS_LENGTH.getValue());
        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
