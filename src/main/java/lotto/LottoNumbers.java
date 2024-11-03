package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static List<Integer> numberList;

    public static List<Integer> randomNumbers() {

        numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumberList = new ArrayList<>(numberList);
        Collections.sort(lottoNumberList);

        return lottoNumberList;
    }
}
