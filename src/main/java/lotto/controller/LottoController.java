package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int lottoCount = getLottoCount();
        outputView.printPurchaseCount(lottoCount);

        List<Lotto> lottos = lottoService.getLottosByCount(lottoCount);
        List<LottoDto> lottoDtos = convertToDto(lottos);
        outputView.printLottos(lottoDtos);

        Lotto winningLotto = getWinningNumber();
        int bonusNumber = getBonusNumber(winningLotto);

        LottoResultDto resultDto = lottoService.getResult(lottos, winningLotto, bonusNumber);
        outputView.printWinningDetail(resultDto);
        outputView.printRevenueResult(resultDto);
    }

    private int getLottoCount() {
        return retryUntilValidInput(() -> {
            String purchaseAmount = inputView.getPurchaseAmount();
            return lottoService.getLottoCountByAmount(purchaseAmount);
        });
    }

    private List<LottoDto> convertToDto(List<Lotto> lottos) {
        return lottos.stream().map(lotto -> new LottoDto(lotto.getNumbers())).toList();
    }

    private Lotto getWinningNumber() {
        return retryUntilValidInput(() -> {
            String winningNumberInput = inputView.getWinningNumbers();
            return lottoService.getWinningLotto(winningNumberInput);
        });
    }

    private int getBonusNumber(Lotto winningLotto) {
        return retryUntilValidInput(() -> {
            String bonusNumberInput = inputView.getBonusNumber();
            winningLotto.validateBonusNumber(bonusNumberInput);
            return Integer.parseInt(bonusNumberInput);
        });
    }

    private <T> T retryUntilValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
