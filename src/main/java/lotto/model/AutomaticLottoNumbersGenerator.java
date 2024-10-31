package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AutomaticLottoNumbersGenerator implements LottoNumbersGenerator {

    public static final int SIZE_OF_NUMBERS = 6;
    public static final int MIN_VALUE_OF_GENERATE = 1;
    public static final int MAX_NUMBER_OF_GENERATE = 45;

    @Override
    public List<Integer> generate() {
        return List.copyOf(Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_GENERATE,
                MAX_NUMBER_OF_GENERATE,
                SIZE_OF_NUMBERS));
    }

}
