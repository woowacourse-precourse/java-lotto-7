package lotto.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class MakeRandomNumbers {

    public static List<Integer> makeRandomLottoNumbers(){
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
