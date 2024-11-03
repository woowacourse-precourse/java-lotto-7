package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private final static int LOTTO_WIN_MIN_NUM = 1;
    private final static int LOTTO_WIN_MAX_NUM = 45;
    private final static int LOTTO_NUM_AMOUNT = 6;


    public static List<Integer> splitWinningNumber(String winningNumber){

        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumber(){

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_WIN_MIN_NUM, LOTTO_WIN_MAX_NUM, LOTTO_NUM_AMOUNT);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
