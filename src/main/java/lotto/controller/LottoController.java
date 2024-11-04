package lotto.controller;

import static lotto.utils.Constant.ERROR_MESSAGE_PREFIX;

import java.util.function.Supplier;
import lotto.domain.InputMoney;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.domain.Lottos;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        InputMoney inputMoney = getInputMoney();
        Lottos lottos = lottoService.buyLottos(inputMoney);
        outputView.displayBuyLottos(lottos);

        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        LottoResult lottoResult = lottoService.findAnswer(lottos, winningNumbers, bonusNumber,inputMoney);
        outputView.displayWinningResult(lottoResult);
    }

    private InputMoney getInputMoney() {
        return retryInput(() ->
                new InputMoney(inputView.getUserInputMoney())
        );
    }

    private WinningNumbers getWinningNumbers() {
        return retryInput(() ->
                new WinningNumbers(inputView.getWinningNumbers())
        );
    }

    private BonusNumber getBonusNumber() {
        return retryInput(() ->
                new BonusNumber(inputView.getBonusNumber())
        );
    }

    private <T> T retryInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();  // 입력 받기 시도
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());  // 에러 메시지 출력
            }
        }
    }
}
