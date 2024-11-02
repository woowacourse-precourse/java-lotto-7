package lotto.custom.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.custom.model.LottoWinningChecker;
import lotto.custom.model.Lottos;

public class LottoResultCheckerService {
    private final LottoWinningChecker lottoWinningChecker;

    public LottoResultCheckerService() {
        this.lottoWinningChecker = new LottoWinningChecker();
    }

    public List<Integer> run(Lottos myLottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));
        lottoWinningChecker.run(myLottoTickets, winningNumbers, bonusNumber, result);
        return result;
    }
}