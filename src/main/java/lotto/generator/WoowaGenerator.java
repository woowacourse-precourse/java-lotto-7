package lotto.generator;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class WoowaGenerator implements Generator{
    @Override
    public List<Integer> generateUniqueNumbers(int start, int end, int num) {
        return Randoms.pickUniqueNumbersInRange(start, end, num);
    }
}
