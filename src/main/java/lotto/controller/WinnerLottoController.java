package lotto.controller;

import static lotto.utils.Constants.ENTER;
import static lotto.utils.RecoveryUtils.executeWithRetry;

import lotto.service.WinnerLottoService;
import lotto.viewer.Viewer;

public class WinnerLottoController {

    private final WinnerLottoService winnerLottoService;
    private final Viewer viewer;

    public WinnerLottoController(WinnerLottoService winnerLottoService, Viewer viewer) {
        this.winnerLottoService = winnerLottoService;
        this.viewer = viewer;
    }

    public void input() {
        viewer.printMessage(ENTER + "당첨 번호를 입력해주세요.");
        executeWithRetry(viewer::getInput, winnerLottoService::addWinnerNumber);

        viewer.printMessage(ENTER + "보너스 번호를 입력해주세요.");
        executeWithRetry(viewer::getInput, winnerLottoService::addBonusNumber);
    }
}
