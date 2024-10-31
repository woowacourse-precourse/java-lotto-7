package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator implements NumberGenerate {

    @Override
    public List<Integer> randomGenerateInRange(int start, int end, int cnt) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, cnt);
        Collections.sort(numbers);
        return numbers;
    }
}
