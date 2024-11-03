package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validation.Validation.*;

public class Utils {

    public static int changeStringToInt(String number) {
        checkInputTypeNumber(number);
        return Integer.parseInt(number);
    }

    public static List<Integer> changeStringToIntegerList(String number) {
        checkInputTypeNumbers(number);
        return Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> randomLottoNumbers(int start , int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }

    public static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
    }

}
