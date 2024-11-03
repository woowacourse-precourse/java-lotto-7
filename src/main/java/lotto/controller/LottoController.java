package lotto.controller;

import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.WinningAnalysisReport;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController extends Controller {
    private final LottoService lottoService;

    public LottoController(LottoInput inputView, LottoOutput outputView, LottoService lottoService) {
        super(inputView, outputView);
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            LottoTickets lottoTickets = buyLottoTickets();
            WinningNumbers winningNumbers = drawWinningNumbers();
            analyzeWinning(lottoTickets, winningNumbers);
        } catch (Exception e) {
            handleError(e);
        }
    }

    private LottoTickets buyLottoTickets() {
        Money money = inputView.getBuyAmount();
        LottoTickets lottoTickets = lottoService.buyLottoTickets(money);
        outputView.displayLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private WinningNumbers drawWinningNumbers() {
        return inputView.getWinningNumbers();
    }

    private void analyzeWinning(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        WinningAnalysisReport report = lottoService.createWinningReport(lottoTickets, winningNumbers);
        outputView.displayReport(report);
    }
}
