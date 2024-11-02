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

    // 티켓 생성
    public void generateLottoTickets(int purchaseAmount) {
        this.lottoTickets = ticketGenerator.createTickets(purchaseAmount);
    }

    // 당첨 번호 설정
    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningTicket = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }


    // 당첨 결과 계산 및 집계
    public Map<PrizeTier, Long> calculateResults() {
        List<PrizeTier> prizeResults = prizeCalculator.calculateResults(lottoTickets, winningTicket, bonusNumber);
        return prizeResults.stream()
                .collect(Collectors.groupingBy(tier -> tier, Collectors.counting()));
    }

    // 수익률 계산
    public double calculateProfitRate(int purchaseAmount) {
        List<PrizeTier> prizeResults = prizeCalculator.calculateResults(lottoTickets, winningTicket, bonusNumber);
        int totalPrize = prizeCalculator.calculateTotalPrize(prizeResults);
        return prizeCalculator.calculateProfitRate(totalPrize, purchaseAmount);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
