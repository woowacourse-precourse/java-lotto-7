package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoNumber {
    public List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRange.LOTTO_LOWEST_NUMBER.getValue(),
                LottoRange.LOTTO_HIGHEST_NUMBER.getValue() - 1,
                6
        );
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}


