package lotto.numberGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

public class LottoRandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE= 45;
    private static final int COUNT = 6;

    public Lotto generateLottoNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
