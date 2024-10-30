package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoMachine {
  private static final int LOTTO_PRICE = 1000;
  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  public int calculateNumberOfTickets(BigDecimal purchaseAmount) {
    return purchaseAmount.divide(BigDecimal.valueOf(LOTTO_PRICE)).intValue();
  }

  public List<Lotto> generateLottoTickets(int ticketCount) {
    Set<List<Integer>> uniqueTickets = new HashSet<>();
    List<Lotto> lottoTickets = new ArrayList<>();

    while (lottoTickets.size() < ticketCount) {
      List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
          LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT
      );
      Collections.sort(numbers);

      if (uniqueTickets.add(numbers)) {
        lottoTickets.add(new Lotto(numbers));
      }
    }

    return lottoTickets;
  }
}
