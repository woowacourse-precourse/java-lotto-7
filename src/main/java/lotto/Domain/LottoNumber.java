package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoNumber {
    public List<Integer> createNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LottoRange.LOTTO_LOWEST_NUMBER.getValue(),
                LottoRange.LOTTO_HIGHEST_NUMBER.getValue(),
                6
        )).stream()
                .sorted()
                .collect(Collectors.toList());
    }
}