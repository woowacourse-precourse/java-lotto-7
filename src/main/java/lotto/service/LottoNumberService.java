package lotto.service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InvalidLottoNumberException;

import static lotto.constant.Constants.*;

public class LottoNumberService {
    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_NUMBERS_COUNT);
    }

    public static List<Integer> splitLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            try {
                if (!number.trim().isEmpty())
                    lottoNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new InvalidLottoNumberException();
            }
        }
        return lottoNumbers;
    }
}
