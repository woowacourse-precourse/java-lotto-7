package lotto.domain;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class LottoNumberGenerater {
    List<Integer> lotto;
    public List<Integer> numberGenerate(){
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }
}



