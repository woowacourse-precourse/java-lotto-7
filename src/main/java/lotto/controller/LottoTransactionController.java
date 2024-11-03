package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoTransaction;
import lotto.model.PrizeRank;

public class LottoTransactionController {
  final int LOTTO_PRICE = 1000; // TODO MainController 말고 다른 곳에 정의할지 생각

  final LottoTransaction lottoTransaction;

  public LottoTransactionController() {
    this.lottoTransaction = new LottoTransaction();
  }

  // TODO amount 대한 vaildate는 sellLotto 또는 inputView에서 할지 생각
  public List<Lotto> sellAutoLotto(int amount) {
    List<Lotto> lottos = new ArrayList<>();
    int count = amount / LOTTO_PRICE;

    while (lottos.size() < count) {
      Lotto lotto = produceLotto();
      lottos.add(lotto);
    }
    System.out.println(count + "개를 구매했습니다."); // TODO 출력 처리 이동
    lottoTransaction.setPurchasedLottos(lottos);
    lottoTransaction.setAmount(amount);

    return lottos;
  }


  public List<Lotto> sellManualLotto(List<List<Integer>> lottoNumbers, int amount) {
    List<Lotto> lottos = new ArrayList<>();
    int count = amount / LOTTO_PRICE;

    for (List<Integer> lottoNumber : lottoNumbers) {
      Lotto lotto = new Lotto(lottoNumber);
      lottos.add(lotto);
    }

    System.out.println(count + "개를 구매했습니다."); // TODO 출력 처리 이동
    lottoTransaction.setPurchasedLottos(lottos);
    lottoTransaction.setAmount(amount);

    return lottos;
  }

  public Map<List<Integer>, PrizeRank> compareWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
    Set<Integer> _winningNumbers = new HashSet<>(winningNumbers);
    Map<List<Integer>, PrizeRank> results = new HashMap<>();

    for (Lotto lotto : lottoTransaction.getPurchasedLottos()) {
      List<Integer> numbers = lotto.getNumbers();
      Set<Integer> _numbers = new HashSet<>(numbers);

      _numbers.retainAll(_winningNumbers);
      PrizeRank prizeRank = PrizeRank.getPrizeRank(_numbers.size(), numbers.contains(bonusNumber));
      results.put(numbers, prizeRank);
      lottoTransaction.addMatchCount(prizeRank);
    }
    return results;
  }

  private Lotto produceLotto() {
    Set<Integer> lottoNumbers = new HashSet<>();

    while (lottoNumbers.size() < 6) {
      int number = Randoms.pickNumberInRange(1, 45);
      lottoNumbers.add(number);
    }
    List<Integer> numbers = new ArrayList<>(lottoNumbers);

    return new Lotto(numbers);
  }
}
