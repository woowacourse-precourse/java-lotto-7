package lotto;

import java.util.HashMap;
import java.util.List;

public interface LottoMachine {
    List<Lotto> purchaseLottoTickets(String money);

    HashMap<LottoRank, Integer> getWinningResult(List<Lotto> lottoTickets, String winningNumbers, String bonusNumber);

    Double calculateProfitRate(HashMap<LottoRank, Integer> winningResult, int purchaseNumber);
}
