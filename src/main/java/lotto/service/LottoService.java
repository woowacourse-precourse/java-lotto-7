package lotto.service;

import lotto.evaluator.LottoEvaluator;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public class LottoService {
    private final LottoTicketGenerator lottoTicketGenerator;
    private final LottoEvaluator lottoEvaluator;

    public LottoService(LottoTicketGenerator lottoTicketGenerator, LottoEvaluator lottoEvaluator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
        this.lottoEvaluator = lottoEvaluator;
    }

    public List<Lotto> generateLottoTickets(int lottoTicketCount) {
        return lottoTicketGenerator.generateMultipleLottoTickets(lottoTicketCount);
    }

    public LottoResult evaluateResults(List<Lotto> lottoTickets, Lotto winningLotto, int bonusNumber) {
        return lottoEvaluator.calculateResults(lottoTickets, winningLotto, bonusNumber);
    }

    public double calculateProfitRate(LottoResult lottoResult, int totalSpent) {
        return lottoResult.calculateProfitRate(totalSpent);
    }
}
