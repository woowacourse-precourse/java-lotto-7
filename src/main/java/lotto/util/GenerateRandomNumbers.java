package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateRandomNumbers implements GenerateNumbers{
    @Override
    public List<Integer> generateNumbers() {
       return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
