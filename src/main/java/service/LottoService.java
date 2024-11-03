package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> issueLottos(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().toList()));
        }
        return tickets;
    }

    public LottoResult checkWin(Lotto ticket, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = ticket.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
        return LottoResult.getResultForMatchAndBonus((int) matchCount, bonusMatch);
    }

    public double calculateProfitRate(List<LottoResult> results, int totalCost) {
        int totalPrize = results.stream().mapToInt(LottoResult::getPrize).sum();
        return ((double) totalPrize / totalCost) * 100;
    }
}
