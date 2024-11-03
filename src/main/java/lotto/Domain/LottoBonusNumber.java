package lotto.Domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoBonusNumber {
    private List<Integer> bonusNumbers;

    public List<Integer> generateBonusNumbers() {
        return new Random()
                .ints(LottoRange.LOTTO_LOWEST_NUMBER,
                        LottoRange.LOTTO_HIGHEST_NUMBER)
                .distinct()
                .limit(1)
                .boxed()
                .collect(Collectors.toList());
    }
}
