package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoConstants;

public class LottoMachine {

  public List<Lotto> generateLottoTickets(int ticketCount) {
    List<Lotto> lottoTickets = new ArrayList<>();

    for (int i = 0; i < ticketCount; i++) {
      List<Integer> numbers = pickUniqueNumbersInRange();
      lottoTickets.add(new Lotto(numbers));
    }

    return lottoTickets;
  }

  private List<Integer> pickUniqueNumbersInRange() {
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER,
        LottoConstants.MAX_LOTTO_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);

    List<Integer> mutableNumbers = new ArrayList<>(numbers);
    Collections.sort(mutableNumbers);
    return mutableNumbers;
  }
}
