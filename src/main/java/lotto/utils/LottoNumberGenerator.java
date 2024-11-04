package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public static List<Integer> responseLottoNumbers(){
      List<Integer> list =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
      return getListOrderByAsc(list);
    }

    private static List<Integer> getListOrderByAsc(List<Integer> list){
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
