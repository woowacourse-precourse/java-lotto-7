package lotto.model.service;

import static lotto.model.domain.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
