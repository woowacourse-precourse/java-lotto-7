package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Utils {
    public static List<Integer> setLottoNums(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
