package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.enums.Constants;

public class LottoService {

    static final String DELIMITER = ",";

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_LOWER_BOUND.getValue(),
                                                Constants.LOTTO_UPPER_BOUND.getValue(),
                                                Constants.LOTTO_NUMBER_SIZE.getValue());
    }

    public List<Integer> getWinningNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(DELIMITER)).map(Integer::parseInt).toList();
    }
}
