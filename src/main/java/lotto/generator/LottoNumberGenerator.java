package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}