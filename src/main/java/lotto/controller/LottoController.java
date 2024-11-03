package lotto.controller;

import lotto.dto.CreateLottoInfo;
import lotto.dto.WinningStatistics;
import lotto.dto.WinningLottoInfo;
import lotto.model.UserLottoInfo;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        UserLottoInfo userLottoInfo = new UserLottoInfo(readPurchaseAmount());
        CreateLottoInfo createLottoInfo = lottoService.getCreateLottoInfo(userLottoInfo);

        outputView.printCreateLottoInfo(createLottoInfo);

        WinningLotto winningLotto = new WinningLotto(readWinningLottoInfo());
        WinningStatistics winningStatistics = lottoService.getLottoRateInfo(winningLotto, userLottoInfo);

        outputView.printWinningStatics(winningStatistics);
    }

    private long readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }

    private WinningLottoInfo readWinningLottoInfo() {
        return new WinningLottoInfo(readWinningNumber(), readBonusNumber());
    }

    private String readWinningNumber() {
        return inputView.readWinningNumber();
    }

    private int readBonusNumber() {
        return inputView.readBonusNumber();
    }
}
