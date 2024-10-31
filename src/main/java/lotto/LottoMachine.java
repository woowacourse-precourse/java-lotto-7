package lotto;

import java.util.HashMap;
import java.util.List;

public interface LottoMachine {
    List<Lotto> createLottoTickets(int count);

    HashMap<LottoRank, Integer> getWinningResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber);
}
