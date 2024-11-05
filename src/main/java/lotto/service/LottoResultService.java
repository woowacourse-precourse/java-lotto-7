package lotto.service;

import lotto.enums.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoResultService {
    private final OutputView outputView;

    public LottoResultService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void displayResults(Map<LottoRank, Integer> results, int purchaseAmount) {
        outputView.displayResults(results, purchaseAmount);
    }

    public Map<LottoRank, Integer> calculateResults(List<LottoTicket> tickets, Lotto winningLotto, LottoBonusNumber bonusNumber) {
        LottoMachine lottoMachine = new LottoMachine(winningLotto);
        return lottoMachine.match(tickets);
    }
}