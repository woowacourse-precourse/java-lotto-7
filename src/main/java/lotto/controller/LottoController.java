package lotto.controller;

import static lotto.utils.RecoveryUtils.executeWithRetry;

import lotto.dto.LottoTicketsDto;
import lotto.dto.MoneyDto;
import lotto.service.LottoService;
import lotto.viewer.Viewer;

public class LottoController {

    private final LottoService lottoService;
    private final Viewer viewer;

    public LottoController(LottoService lottoService, Viewer viewer) {
        this.lottoService = lottoService;
        this.viewer = viewer;
    }

    public void buy() {
        MoneyDto moneyDto = getMoney();
        getLotto(moneyDto);
    }

    protected MoneyDto getMoney() {
        viewer.printMessage("구입금액을 입력해 주세요.");
        return executeWithRetry(viewer::getInput, lottoService::createMoney);
    }

    protected void getLotto(MoneyDto moneyDto) {
        viewer.printMessage(moneyDto.lottoCount());
        LottoTicketsDto lottoTicketsDto = lottoService.generateLottoTickets();
        viewer.printMessage(lottoTicketsDto.ticketsMessage());
    }
}
