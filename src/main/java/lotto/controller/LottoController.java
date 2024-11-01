package lotto.controller;

import static lotto.utils.Constants.ENTER;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
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

    public void buyLotto() {
        MoneyDto moneyDto = getMoney();
        getLotto(moneyDto);
    }

    public void createWinnerLotto() {
        viewer.printMessage(ENTER + "당첨 번호를 입력해주세요.");
        executeWithRetry(viewer::getInput, lottoService::addWinnerLotto);

        viewer.printMessage(ENTER + "보너스 번호를 입력해주세요.");
        executeWithRetry(viewer::getInput, lottoService::addBonusNumber);
    }

    public void calculateWinnerStatus() {
        WinnerStatusDto winnerStatusDto = lottoService.calculateWinnerStatus();
        viewer.printMessage(winnerStatusDto.message());
    }

    public void calculateProfitRate() {
        ProfitRateResultDto profitRateResultDto = lottoService.calculateProfitRate();
        viewer.printMessage(profitRateResultDto.resultMessage());
    }

    private MoneyDto getMoney() {
        viewer.printMessage("구입금액을 입력해 주세요.");

        return executeWithRetry(viewer::getInput, lottoService::createMoney);
    }

    private void getLotto(MoneyDto moneyDto) {
        viewer.printMessage(moneyDto.lottoCount());
        LottoListDto lottoListDto = lottoService.generateLottoList();
        viewer.printMessage(lottoListDto.listMessage());
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

    private <T> void executeWithRetry(Supplier<T> inputSupplier, Consumer<T> processFunction) {
        while (true) {
            try {
                T input = inputSupplier.get();
                processFunction.accept(input);
                return;
            } catch (IllegalArgumentException e) {
                viewer.printError(e);
            }
        }
    }
}
