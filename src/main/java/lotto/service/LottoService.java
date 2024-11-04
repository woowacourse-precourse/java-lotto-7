package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

  public List<Lotto> lottoResults(long numberOfPurchases){
    List<Lotto> lottos=new ArrayList<>();
    for(int i=0;i<numberOfPurchases;i++){
      lottos.add(new Lotto(numberLottery()));
    }
    return lottos;
  }

  List<Integer> numberLottery(){
      List<Integer> numbers=new ArrayList<>();
      numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
      return numbers;
  }

  public void calculatingWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {

  }
}
