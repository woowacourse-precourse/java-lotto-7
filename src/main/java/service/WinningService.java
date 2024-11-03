package service;


import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Profit;
import domain.Ticket;
import domain.Winning;
import domain.WinningPrice;
import java.util.List;
import java.util.Map;
import utils.RandomNumber;
import utils.WinningCalculator;

public class WinningService {

    private Ticket ticket;
    private Lottos lottos = Lottos.create();
    private LottoResult lottoResult = LottoResult.create();
    private Winning winning;

    public Lottos generateLottoNumber(int purchaseAmount) {
        ticket = Ticket.from(purchaseAmount);
        for(int i=0; i<ticket.getQuantity(); i++) {
            Lotto lotto = new Lotto(RandomNumber.create());
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    public int getTicketQuantity() {
        return ticket.getQuantity();
    }

    public void winningStatistics(List<Integer> winningNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        winning = Winning.of(winningNumbers, bonusNumber);
        int matchCount = WinningCalculator.countMatchingNumber(winning.getNumbers(), lottoNumbers);
        boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(lottoNumbers,
                winning.getBonusNumber());
        WinningPrice winningPrice = WinningPrice.of(matchCount, bonusNumberMatched);
        lottoResult.countWinningPrice(winningPrice);
    }

    public Map<WinningPrice, Integer> getLottoResult() {
        return lottoResult.getResult();
    }

    public String getProfit(int purchaseAmount) {
        return Profit.calculate(lottoResult.getResult(), purchaseAmount);
    }


}
