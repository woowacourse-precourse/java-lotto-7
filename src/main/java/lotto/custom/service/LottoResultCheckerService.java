package lotto.custom.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.custom.model.LottoResultAnalyzer;
import lotto.custom.model.Lottos;

public class LottoResultCheckerService {
    private final LottoResultAnalyzer lottoResultAnalyzer;

    public LottoResultCheckerService() {
        this.lottoResultAnalyzer = new LottoResultAnalyzer();
    }

    public List<Integer> run(Lottos myLottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));
        lottoResultAnalyzer.run(myLottoTickets, winningNumbers, bonusNumber, result);
        return result;
    }
}