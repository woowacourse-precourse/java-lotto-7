package service;


import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Profit;
import domain.Ticket;
import domain.Winning;
import domain.WinningPrice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.RandomNumber;
import utils.WinningCalculator;

public class WinningService {

    private Ticket ticket;
    private Lottos lottos = Lottos.create();
    private LottoResult lottoResult = LottoResult.create();
    private Winning winning;

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

    public int getTicketQuantity() {
        return ticket.getQuantity();
    }

    public void winningStatistics(List<Integer> winningNumbers, List<List<Integer>> lottos, int bonusNumber) {
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

    public String getProfit(int purchaseAmount) {
        return Profit.calculate(lottoResult.getResult(), purchaseAmount);
    }


}
