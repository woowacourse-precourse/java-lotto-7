package lotto.controller;

import lotto.dto.GeneratedLottoInfo;
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
        UserLottoInfo userLottoInfo = generateUserLottoInfo();
        GeneratedLottoInfo generatedLottoInfo = generateLottoInfo(userLottoInfo);
        outputView.printCreateLottoInfo(generatedLottoInfo);

        WinningLotto winningLotto = new WinningLotto(readWinningLottoInfo());
        WinningStatistics winningStatistics = lottoService.getLottoRateInfo(winningLotto, userLottoInfo);

        outputView.printWinningStatics(winningStatistics);
    }

    private GeneratedLottoInfo generateLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
        return lottoService.getGeneratedLottoInfo(userLottoInfo);
    }

    private UserLottoInfo generateUserLottoInfo() {
        while (true) {
            try {
                return new UserLottoInfo(readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private long readPurchaseAmount() {
        while (true) {
            try {
                return inputView.readPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }

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
