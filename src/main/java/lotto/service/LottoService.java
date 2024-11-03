package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;

public class LottoService {
    private final LottoStore lottoStore;
    private final LottoResults lottoResults;

    public LottoService() {
        this.lottoStore = new LottoStore();
        this.lottoResults = new LottoResults();
    }

    public LottoTickets purchaseLottoTickets(int amount){
        LottoPurchase purchase = LottoPurchase.of(amount);
        return lottoStore.generateLottoTickets(purchase.getTicketCount());
    }

    public List<LottoResultDto> calculateResults(LottoTickets tickets , WinningNumbers winningNumbers, BonusNumber bonusNumber){
        lottoResults.calculateResults(tickets,winningNumbers,bonusNumber);
        return lottoResults.generateResultDtos();
    }

    public double calculateTotalEarningsRate(int purchaseAmount) {
        long totalEarnings = lottoResults.calculateTotalEarnings();
        return (double) totalEarnings / purchaseAmount * 100;
    }
}
