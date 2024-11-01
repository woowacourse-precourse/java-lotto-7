package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Model.Lotto;

public class Utils {
    public static List<Integer> setLottoNums(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void printLottos(List<Lotto> lottos){
        lottos.stream().forEach(lotto -> lotto.printLotto());
    }
}
