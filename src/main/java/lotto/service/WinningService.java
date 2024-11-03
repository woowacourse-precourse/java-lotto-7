package lotto.service;


import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.Ticket;
import lotto.domain.WinningPrice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.utils.RandomNumber;
import lotto.utils.WinningCalculator;

public class WinningService {

    private Ticket ticket;
    private Lottos lottos = Lottos.create();
    private LottoResult lottoResult = LottoResult.create();

    public int buyTicket(int purchaseAmount) {
        ticket = Ticket.from(purchaseAmount);
        return ticket.getQuantity();
    }

    public List<List<Integer>> generateLottoNumber(int ticketQuantity) {
        List<List<Integer>> tmpLottos = new ArrayList<>();
        for (int i = 0; i < ticketQuantity; i++) {
            Lotto lotto = new Lotto(RandomNumber.create());
            lottos.addLotto(lotto);
            tmpLottos.add(lotto.getNumbers());
        }
        return tmpLottos;
    }

    public void winningStatistics(List<Integer> winningNumbers, List<List<Integer>> lottos,
            int bonusNumber) {
        for (List<Integer> lotto : lottos) {
            int matchCount = WinningCalculator.countMatchingNumber(winningNumbers, lotto);
            boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(lotto, bonusNumber);
            WinningPrice winningPrice = WinningPrice.of(matchCount, bonusNumberMatched);
            lottoResult.countWinningPrice(winningPrice);
        }
    }

    public Map<WinningPrice, Integer> getLottoResult() {
        return lottoResult.getResult();
    }

    public String getProfit() {
        return Profit.calculate(lottoResult.getResult(), ticket.getPurchaseAmount());
    }

}
