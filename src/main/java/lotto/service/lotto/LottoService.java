package lotto.service.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.PurchasedLottos;
import lotto.service.lotto.constant.LottoConstant;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class LottoService {

  public int getPrice() {
    return LottoConstant.PRICE;
  }

  public PurchasedLottos purchaseLottos (int lottoCount) {
    return PurchasedLottos.from(createLottos(lottoCount));
  }

  private List<Lotto> createLottos(int count) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < count; ++i) {
      lottos.add(createLotto(generateRandomNumbers()));
    }
    return lottos;
  }

  private List<Integer> generateRandomNumbers() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  private Lotto createLotto(List<Integer> numbers) {
    return Lotto.from(numbers);
  }
}
