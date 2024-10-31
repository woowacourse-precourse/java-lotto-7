package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoMachine {
  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  public List<Lotto> generateLottoTickets(int ticketCount) {
    List<Lotto> lottoTickets = new ArrayList<>();

    for (int i = 0; i < ticketCount; i++) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
          LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT
      );
      Collections.sort(numbers);
      lottoTickets.add(new Lotto(numbers));
    }

    return lottoTickets;
  }
}
