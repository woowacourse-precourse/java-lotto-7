package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER, Constants.LOTTO_NUMBER_SIZE);
        return createLotto(lottoNumbers);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(new ArrayList<>(numbers));
    }
}
