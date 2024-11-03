package lotto.service;

import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.model.BonusNumber;
import lotto.model.LottoTickets;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoStore lottoStore;
    private final LottoResults lottoResults;

    public LottoService() {
        this.lottoStore = new LottoStore();
        this.lottoResults = new LottoResults();
    }

    public List<LottoTicketsDto> purchaseLottoTickets(int amount) {
        int ticketCount = lottoStore.calculateLottoCount(amount);
        LottoTickets tickets = lottoStore.generateLottoTickets(ticketCount);
        return tickets.getLottoTickets().stream()
                .map(lotto -> new LottoTicketsDto(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    public LottoResultDto calculateResult(LottoTickets tickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Rank, Integer> resultMap = lottoResults.calculateResult(tickets, winningNumbers, bonusNumber);
        long totalEarnings = lottoResults.calculateTotalEarnings(resultMap);
        double profitRate = getProfitRate(tickets, (double) totalEarnings);
        return new LottoResultDto(resultMap, profitRate);
    }

    private double getProfitRate(LottoTickets tickets, double totalEarnings) {
        return (totalEarnings / (tickets.size() * 1000)) * 100;
    }
}