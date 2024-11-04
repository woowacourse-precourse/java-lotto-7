package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(final OutputView outputView, final InputView inputView, final LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        final LottoCount lottoCount = getLottoCount();
        outputView.printPurchaseCount(lottoCount.getCount());

        final List<Lotto> lottos = lottoService.getLottosByCount(lottoCount);
        final List<LottoDto> lottoDtos = lottoService.convertToDto(lottos);
        outputView.printLottos(lottoDtos);

        final Lotto winningLotto = getWinningNumber();
        int bonusNumber = getBonusNumber(winningLotto);

        final LottoResultDto resultDto = lottoService.getResult(lottos, winningLotto, bonusNumber);
        outputView.printWinningResult(resultDto);
    }

    private LottoCount getLottoCount() {
        return retryUntilValidInput(() -> {
            final String purchaseAmount = inputView.getPurchaseAmount();
            return lottoService.getLottoCountByAmount(purchaseAmount);
        });
    }

    private Lotto getWinningNumber() {
        return retryUntilValidInput(() -> {
            final String winningNumberInput = inputView.getWinningNumbers();
            return lottoService.getWinningLotto(winningNumberInput);
        });
    }

    private int getBonusNumber(final Lotto winningLotto) {
        return retryUntilValidInput(() -> {
            final String bonusNumberInput = inputView.getBonusNumber();
            winningLotto.validateBonusNumber(bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        });
    }

    private <T> T retryUntilValidInput(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
