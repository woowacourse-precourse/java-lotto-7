package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoTransaction;

public class LottoTransactionController {
  final int LOTTO_PRICE = 1000; // TODO MainController 말고 다른 곳에 정의할지 생각

  final LottoTransaction lottoTransaction;

  public LottoTransactionController() {
    this.lottoTransaction = new LottoTransaction();
  }

  // TODO amount 대한 vaildate는 sellLotto 또는 inputView에서 할지 생각
  public List<Lotto> sellLotto(int amount) {
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

  public void compareWinningNumbers(List<Integer> winningNumbers) {

    Set<Integer> _winningNumbers = new HashSet<>(winningNumbers);
    List<Lotto> lotttos = lottoTransaction.getPurchasedLottos();

    System.out.println("당첨 번호:" + winningNumbers); // TODO test용 삭제 예정

    for (Lotto lotto : lotttos) {
      List<Integer> numbers = lotto.getNumbers();
      Set<Integer> _numbers = new HashSet<>(numbers);
      _numbers.retainAll(_winningNumbers);
      System.out.println(numbers + "\t일치 갯수:" + _numbers.size()); // TODO test용 삭제 예정
    }
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
