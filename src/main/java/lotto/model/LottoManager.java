package lotto.model;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

// 로또 서비스 구현
// 로또 번호 추출
public class LottoManager {

    public List<Integer>generateLottoNumbers(){
        return pickUniqueNumbersInRange(1,45,6);
    }


}
