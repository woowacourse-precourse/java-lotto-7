package service;


import domain.Lotto;
import domain.LottoResult;
import domain.Lottos;
import domain.Ticket;
import domain.WinningPrice;
import java.util.List;
import java.util.Map;
import utils.RandomNumber;
import utils.WinningCalculator;

public class WinningService {

    private Ticket ticket;
    private Lottos lottos = new Lottos();
    private LottoResult lottoResult = LottoResult.create();

    public Lottos generateLottoNumber(int purchaseAmount) {
        ticket = Ticket.from(purchaseAmount);
        for(int i=0; i<ticket.getQuantity(); i++) {
            Lotto lotto = Lotto.from(RandomNumber.create());
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    public int getTicketQuantity() {
        return ticket.getQuantity();
    }

    public void winningStatistics(List<Integer> winningNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        int matchCount = WinningCalculator.countMatchingNumber(winningNumbers, lottoNumbers);
        boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(winningNumbers,
                bonusNumber);
        WinningPrice winningPrice = WinningPrice.of(matchCount, bonusNumberMatched);
        lottoResult.countWinningPrice(winningPrice);
    }

    public Map<WinningPrice, Integer> getLottoResult() {
        return lottoResult.getResult();
    }


}
