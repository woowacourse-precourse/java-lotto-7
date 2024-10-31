package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.util.LottoTicketFactory;
import lotto.util.PrizeCalculator;

public class LottoService {

    private final LottoTicketFactory ticketFactory;
    private final PrizeCalculator prizeCalculator;
    private List<Lotto> purchasedTickets;
    private Lotto winningLotto;

    public LottoService(LottoTicketFactory ticketFactory, PrizeCalculator prizeCalculator) {
        this.ticketFactory = ticketFactory;
        this.prizeCalculator = prizeCalculator;
    }

    public void generateLottoTickets(int purchaseAmount) {
        this.purchasedTickets = ticketFactory.createTickets(purchaseAmount);
    }

    public List<Lotto> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.prizeCalculator.setBonusNumber(bonusNumber);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public List<PrizeTier> calculateResults() {
        return prizeCalculator.calculateResults(purchasedTickets, winningLotto);
    }

    public double calculateProfitRate(List<PrizeTier> prizeResults, int purchaseAmount) {
        return prizeCalculator.calculateProfitRate(prizeResults, purchaseAmount);
    }

    public Map<PrizeTier, Integer> getWinningCounts(List<PrizeTier> prizeResults) {
        return prizeResults.stream()
                .collect(Collectors.toMap(
                        tier -> tier,
                        tier -> 1,
                        Integer::sum
                ));
    }

}
