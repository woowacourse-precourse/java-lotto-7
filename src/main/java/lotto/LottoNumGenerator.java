package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class LottoNumGenerator {
    public List<Integer> generateNum(){
        List numbers = new ArrayList<Integer>();
        numbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(null);
        return numbers;
    }
}
