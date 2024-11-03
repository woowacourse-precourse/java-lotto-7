package lotto.lottoapp.model;

import java.util.List;
import lotto.common.util.RandomUtil;

public class AutomaticLottoNumbersGenerator implements LottoNumbersGenerator {

    public static final int SIZE_OF_NUMBERS = 6;
    public static final int MIN_VALUE_OF_GENERATE = 1;
    public static final int MAX_NUMBER_OF_GENERATE = 45;

    @Override
    public List<Integer> generate() {
        return List.copyOf(RandomUtil.pickUniqueNumbersInRange(
                MIN_VALUE_OF_GENERATE, MAX_NUMBER_OF_GENERATE, SIZE_OF_NUMBERS));
    }

}
