package lotto.controller;

import static lotto.utils.Constants.ENTER;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.domain.WinnerLotto;
import lotto.dto.LottoListDto;
import lotto.dto.MoneyDto;
import lotto.dto.ProfitRateResultDto;
import lotto.dto.WinnerStatusDto;
import lotto.service.LottoService;
import lotto.viewer.Viewer;

public class LottoController {

    private final LottoService lottoService;
    private final Viewer viewer;

    public LottoController(LottoService lottoService, Viewer viewer) {
        this.lottoService = lottoService;
        this.viewer = viewer;
    }

    public void run() {
        MoneyDto moneyDto = getMoney();
        LottoListDto lottoListDto = buyLotto(moneyDto);
        WinnerLotto winnerLotto = createWinnerLotto();
        WinnerStatusDto winnerStatus = calculateWinnerStatus(lottoListDto, winnerLotto);
        calculateProfitRate(winnerStatus, moneyDto);
    }

    public MoneyDto getMoney() {
        viewer.printMessage("구입금액을 입력해 주세요.");

        return executeWithRetry(viewer::getInput, lottoService::covertToMoney);
    }

    public LottoListDto buyLotto(MoneyDto moneyDto) {
        viewer.printMessage(moneyDto.lottoCount());
        LottoListDto lottoListDto = lottoService.generateLottoList(moneyDto);
        viewer.printMessage(lottoListDto.listMessage());

        return lottoListDto;
    }

    // TODO DTO 필드 분리하여 만들기
    public WinnerLotto createWinnerLotto() {
        viewer.printMessage(ENTER + "당첨 번호를 입력해주세요.");
        WinnerLotto winnerLotto = executeWithRetry(viewer::getInput, lottoService::addWinnerLotto);

        viewer.printMessage(ENTER + "보너스 번호를 입력해주세요.");
        return executeWithRetry(viewer::getInput, bonus -> lottoService.addBonusNumber(winnerLotto, bonus));
    }

    public WinnerStatusDto calculateWinnerStatus(LottoListDto lottoListDto, WinnerLotto winnerLotto) {
        WinnerStatusDto winnerStatusDto = lottoService.calculateWinnerStatus(lottoListDto, winnerLotto);
        viewer.printMessage(winnerStatusDto.message());

        return winnerStatusDto;
    }

    public ProfitRateResultDto calculateProfitRate(WinnerStatusDto winnerStatus, MoneyDto moneyDto) {
        ProfitRateResultDto profitRateResultDto = lottoService.calculateProfitRate(winnerStatus, moneyDto);
        viewer.printMessage(profitRateResultDto.resultMessage());

        return profitRateResultDto;
    }


    private <T, R> R executeWithRetry(Supplier<T> inputSupplier, Function<T, R> processFunction) {
        while (true) {
            try {
                return processFunction.apply(inputSupplier.get());
            } catch (IllegalArgumentException e) {
                viewer.printError(e);
            }
        }
    }

}
