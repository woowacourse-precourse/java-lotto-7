package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.Validation;

import java.util.Collections;
import java.util.List;

public class Utils {

    public static int changeStringToInt(String number) {
        Validation.checkInputTypeNumber(number);
        return Integer.parseInt(number);
    }

    public static List<Integer> randomLottoNumbers(int start , int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }

    public static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
