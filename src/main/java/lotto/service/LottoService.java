package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public static List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Integer> splitLottoNumbers(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : input.split(",")) {
            try {
                lottoNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호를 다시 확인해 주세요.");
            }
        }
        return lottoNumbers;
    }
}
