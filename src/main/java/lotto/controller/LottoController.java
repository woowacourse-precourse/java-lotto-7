package lotto.controller;

import lotto.dto.GeneratedUserLotto;
import lotto.dto.WinningStatistics;
import lotto.model.Lotto;
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
        GeneratedUserLotto generatedUserLotto = generateLottoInfo(userLottoInfo);
        outputView.printCreateLottoInfo(generatedUserLotto);

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

    private GeneratedUserLotto generateLottoInfo(lotto.model.UserLottoInfo userLottoInfo) {
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
        Lotto winningLotto = generatedWinningNumber();

        while(true) {
            try {
                return new WinningLotto(winningLotto, readBonusNumber());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private Lotto generatedWinningNumber() {
        while(true) {
            try {
                return new Lotto(readWinningNumber());
            }catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private String readWinningNumber() {
        return inputView.readWinningNumber();
    }

    private int readBonusNumber() {
        return inputView.readBonusNumber();
    }
}
