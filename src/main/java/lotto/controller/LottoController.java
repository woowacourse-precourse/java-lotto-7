package lotto.controller;

import static lotto.util.Parser.parseLottoNumber;
import static lotto.util.Parser.parseLottoNumberInteger;
import static lotto.util.Parser.parsePriceInteger;

import java.util.function.Supplier;
import lotto.dto.LottoStatistics;
import lotto.dto.LottosDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        Lottos lottos = lottoService.buyLottos(inputPrice());
        printBoughtLottosInfo(lottos);
        WinningLotto winningLotto = inputWinningLotto();
        outputView.printStatistics(LottoStatistics.from(
                winningLotto,
                lottos
        ));
    }

    private WinningLotto inputWinningLotto() {
        Lotto lotto = inputDrawLotto();
        return handleInput(() -> new WinningLotto(
                lotto,
                inputBonusNumber()
        ));
    }

    private BonusNumber inputBonusNumber() {
        return handleInput(() -> {
            outputView.printInputBonusNumber();
            String bonusNumber = inputView.readBonusNumber();
            return new BonusNumber(parseLottoNumberInteger(bonusNumber));
        });
    }

    private Lotto inputDrawLotto() {
        return handleInput(() -> {
            outputView.printInputWinningNumbers();
            String winningNumber = inputView.readWinningLottoNumber();
            return new Lotto(parseLottoNumber(winningNumber));
        });
    }

    private int inputPrice() {
        return handleInput(() -> {
            outputView.printInputPriceMessage();
            return parsePriceInteger(inputView.readPrice());
        });
    }

    private void printBoughtLottosInfo(Lottos lottos) {
        outputView.printDisplayBuyCountMessage(LottosDTO.from(lottos));
    }

    private <T> T handleInput(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
