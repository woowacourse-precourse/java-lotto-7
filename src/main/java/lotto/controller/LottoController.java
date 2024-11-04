package lotto.controller;

import static lotto.util.Parser.parseLottoNumber;
import static lotto.util.Parser.parseLottoNumberInteger;
import static lotto.util.Parser.parsePriceInteger;

import java.util.function.Supplier;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.LottosDTO;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
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
        printBoughtLottoInfo(LottosDTO.from(lottos));
        WinningLotto winningLotto = inputWinningLotto();
        LottoResult lottoStatistics = lottoService.getStatistics(winningLotto, lottos);
        outputView.printStatistics(LottoStatisticsDTO.from(lottoStatistics, lottos.amount()));
    }

    private WinningLotto inputWinningLotto() {
        Lotto lotto = inputDrawLotto();
        return handleInput(() -> lottoService.generateWinningLotto(
                lotto,
                inputBonusNumber()
        ));
    }

    private BonusNumber inputBonusNumber() {
        return handleInput(() -> {
            outputView.printInputBonusNumber();
            String bonusNumber = inputView.readBonusNumber();
            return lottoService.generateBonusNumber(parseLottoNumberInteger(bonusNumber));
        });
    }

    private Lotto inputDrawLotto() {
        return handleInput(() -> {
            outputView.printInputWinningNumbers();
            String winningNumber = inputView.readWinningLottoNumber();
            return lottoService.generateLotto(parseLottoNumber(winningNumber));
        });
    }

    private int inputPrice() {
        return handleInput(() -> {
            outputView.printInputPriceMessage();
            return parsePriceInteger(inputView.readPrice());
        });
    }

    private void printBoughtLottoInfo(LottosDTO lottosDTO) {
        outputView.printDisplayBuyCountMessage(lottosDTO);
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
