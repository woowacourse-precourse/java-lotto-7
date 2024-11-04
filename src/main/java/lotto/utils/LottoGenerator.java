package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.Lotto;

import java.util.List;

import static lotto.message.UtilNumber.*;

public class LottoGenerator {
    public static Lotto createLotto() throws LottoException {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getNumber(),
                MAX_LOTTO_NUMBER.getNumber(),
                LOTTO_LENGTH.getNumber());
        return new Lotto(lottoNumbers);
    }
}