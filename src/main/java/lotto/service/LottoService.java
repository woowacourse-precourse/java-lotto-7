package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.PrizeTier;
import lotto.util.LottoTicketGenerator;

public class LottoService {

    private final LottoTicketGenerator ticketGenerator;
    private final PrizeCalculator prizeCalculator;
    private List<Lotto> lottoTickets;
    private Lotto winningTicket;

    public LottoService(LottoTicketGenerator ticketGenerator, PrizeCalculator prizeCalculator) {
        this.ticketGenerator = ticketGenerator;
        this.prizeCalculator = prizeCalculator;
    }

    public void generateLottoTickets(int purchaseAmount) {
        this.lottoTickets = ticketGenerator.createTickets(purchaseAmount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningTicket = new Lotto(winningNumbers);
        this.prizeCalculator.setBonusNumber(bonusNumber);
    }

    public Lotto getWinningTicket() {
        return winningTicket;
    }

    public List<PrizeTier> calculateResults() {
        return prizeCalculator.calculateResults(lottoTickets, winningTicket);
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
