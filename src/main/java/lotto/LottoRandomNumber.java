package lotto;

import NumberGenerator.RandomNumber;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoRandomNumber implements RandomNumber {

    private static final int startNumber = 1;
    private static final int endNumber = 45;
    private static final int count = 6;

    @Override
    public List<Integer> randomLottoNumbers(){
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);
        return orderedByAsc(lotto);
    }

    private List<Integer> orderedByAsc(List<Integer> lotto){
        Collections.sort(lotto);
        return lotto;
    }

}
