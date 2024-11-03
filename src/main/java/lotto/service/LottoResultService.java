package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.customer.Customer;
import lotto.dto.ResultDto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Rank;
import lotto.model.lotto.WinningLotto;

public class LottoResultService {
    public WinningLotto registerWinningNumbers(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public void determineRanks(Customer customer, WinningLotto winningLotto) {
        customer.determineRanksOfLottoTickets(winningLotto);
    }

    public ResultDto getResult(Customer customer) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();
        return ResultDto.from(customer.countRank(rankCounts), customer.calculateProfitRate());
    }

    private Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> rankCounts = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.OUT_OF_RANK)) {
                continue;
            }
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }
}
