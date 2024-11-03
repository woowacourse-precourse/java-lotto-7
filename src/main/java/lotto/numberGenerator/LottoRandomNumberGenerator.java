package lotto.numberGenerator;

import java.util.List;

public class LottoRandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE= 45;
    private static final int COUNT = 6;

    public List<Integer> generateLottoNumbers(){
        return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,COUNT);
    }
}
