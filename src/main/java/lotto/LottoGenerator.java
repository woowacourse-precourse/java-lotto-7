package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {


  public List<Lotto> generateLotto(int purchaseQuantity) {
    List<Lotto> lottoPaper = new ArrayList<>();
    for (int i = 0; i < purchaseQuantity; i++) {
      lottoPaper.add(new Lotto(generateOneLotto()));
    }
    return lottoPaper;
  }

  public void printLotto(List<Lotto> lottoPaper)
  {
    for(Lotto lotto : lottoPaper)
    {
      lotto.lottoToString();
    }
  }

  public List<Integer> generateOneLotto() {

    return Randoms.pickUniqueNumbersInRange(1, 45, 6);

  }

}
