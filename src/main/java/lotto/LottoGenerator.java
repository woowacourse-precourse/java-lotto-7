package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

  public List<Integer> generateOneLotto(){
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

}
