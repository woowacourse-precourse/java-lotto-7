package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoGenerator {

    public static List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoNumbers.sort(Integer::compareTo); // 오름차순 정렬
        return lottoNumbers;
    }
}
