package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {
    public RandomLotto(){
    }

    public static List<Integer> randomLottoNumber(){
        List<Integer> lottoNumberList =new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }
}
