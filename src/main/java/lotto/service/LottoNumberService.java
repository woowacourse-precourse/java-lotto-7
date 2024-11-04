package lotto.service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

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
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 다시 확인해 주세요.");
            }
        }
        return lottoNumbers;
    }
}
