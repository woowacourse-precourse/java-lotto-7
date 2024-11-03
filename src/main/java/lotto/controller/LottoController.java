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

        WinningStatistics winningStatistics = generatedWinningStatistics(userLottoInfo);
        outputView.printWinningStatics(winningStatistics);
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
        return inputView.readPurchaseAmount();
    }

    private GeneratedLottoInfo generateLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
        return lottoService.getGeneratedLottoInfo(userLottoInfo);
    }

    private WinningStatistics generatedWinningStatistics(UserLottoInfo userLottoInfo) {
        while(true) {
            try {
                return lottoService.getWinningStatistics(generatedWinningLotto(), userLottoInfo);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private WinningLotto generatedWinningLotto() {
        return new WinningLotto(readWinningLottoInfo());
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
