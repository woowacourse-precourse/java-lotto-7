package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static int MIN_NUMBER = 1;
    private static int MAX_NUMBER = 45;
    private static int LOTTO_NUMBER_SIZE = 6;

    public static Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_SIZE);
        return createLotto(lottoNumbers);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(new ArrayList<>(numbers));
    }
}
