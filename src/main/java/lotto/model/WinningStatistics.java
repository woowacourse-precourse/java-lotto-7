package lotto.model;

import java.util.List;
import java.util.Map;
import lotto.service.CheckingWinningService;

public class WinningStatistics {
    //당첨번호, 보너스 번호, 로또 번호 -> 일치
    //통계, 수익률 -> 출력
    private final CheckingWinningService checkingWinningService;

    public WinningStatistics(CheckingWinningService checkingWinningService) {
        this.checkingWinningService = checkingWinningService;
    }

    public Map<Integer, Integer> getRanks(List<Integer> winningNumbers, int bonusNumber, List<Lotto> LottoTickets) {
        List<Integer> numberOfMatches = checkingWinningService.getNumberOfMatches(LottoTickets, winningNumbers);
        checkingWinningService.checkBonusWinning(LottoTickets, numberOfMatches, bonusNumber);
        return checkingWinningService.calculateRanks(numberOfMatches);
    }

    public double getRateOfWinning() {

    }
}
