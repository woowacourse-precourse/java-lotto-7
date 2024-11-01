package lotto;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class RandomLottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private RandomLottoNumberGenerator() {
        throw new AssertionError("Not instantiable");
    }

    public static List<LottoNumber> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber generateSingleNumber() {
        return new LottoNumber(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
    }

}
