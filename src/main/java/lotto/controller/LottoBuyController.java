package lotto.controller;

import static lotto.utils.RecoveryUtils.executeWithRetry;

import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.service.LottoBuyService;
import lotto.viewer.Viewer;

public class LottoBuyController {

    private final LottoBuyService lottoBuyService;
    private final Viewer viewer;

    public LottoBuyController(LottoBuyService lottoBuyService, Viewer viewer) {
        this.lottoBuyService = lottoBuyService;
        this.viewer = viewer;
    }

    public void process() {
        MoneyDto moneyDto = getMoney();
        getLotto(moneyDto);
    }

    private MoneyDto getMoney() {
        viewer.printMessage("구입금액을 입력해 주세요.");

        return executeWithRetry(viewer::getInput, lottoBuyService::createMoney);
    }

    private void getLotto(MoneyDto moneyDto) {
        viewer.printMessage(moneyDto.lottoCount());
        LottoListDto lottoListDto = lottoBuyService.generateLottoList();
        viewer.printMessage(lottoListDto.listMessage());
    }
}
