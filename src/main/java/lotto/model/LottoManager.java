package lotto.model;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoManager {
    public Lotto generateLottoNumbers(){
        return new Lotto(pickUniqueNumbersInRange(1,45,6));
    }

}
