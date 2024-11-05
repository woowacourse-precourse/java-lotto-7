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
    private int bonusNumber;

    public LottoService(LottoTicketGenerator ticketGenerator, PrizeCalculator prizeCalculator) {
        this.ticketGenerator = ticketGenerator;
        this.prizeCalculator = prizeCalculator;
    }

    public void generateLottoTickets(int purchaseAmount) {
        this.lottoTickets = ticketGenerator.createTickets(purchaseAmount);
    }

    // 당첨 번호 설정
    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningTicket = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    // 당첨 결과 집계
    public Map<PrizeTier, Long> calculateResults() {
        List<PrizeTier> prizeResults = calculatePrizeResults();
        return prizeResults.stream()
                .collect(Collectors.groupingBy(tier -> tier, Collectors.counting()));
    }

    // 수익률 계산
    public double calculateProfitRate(int purchaseAmount) {
        int totalPrize = calculateTotalPrize();
        return calculateProfitRate(totalPrize, purchaseAmount);
    }

    private List<PrizeTier> calculatePrizeResults() {
        return prizeCalculator.calculateResults(lottoTickets, winningTicket, bonusNumber);
    }

    private int calculateTotalPrize() {
        List<PrizeTier> prizeResults = calculatePrizeResults();
        return prizeCalculator.calculateTotalPrize(prizeResults);
    }

    private double calculateProfitRate(int totalPrize, int purchaseAmount) {
        return prizeCalculator.calculateProfitRate(totalPrize, purchaseAmount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

}
