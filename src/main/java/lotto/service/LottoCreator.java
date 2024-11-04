package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {
    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER.getValue(),
                LottoConstant.MAX_LOTTO_NUMBER.getValue(),
                LottoConstant.LOTTO_NUMBERS_LENGTH.getValue());
        List<Integer> lottoNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
