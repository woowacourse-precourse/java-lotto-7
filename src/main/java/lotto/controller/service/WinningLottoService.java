package lotto.controller.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.extractor.LottoExtractor;
import lotto.io.input.InputHandler;
import lotto.io.request.BonusNumberRequest;
import lotto.io.request.LottoRequest;

public class WinningLottoService {

    private final InputHandler inputHandler;

    public WinningLottoService() {
        this.inputHandler = new InputHandler();
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumber();
        int bonusNumber = getBonusNumber(lotto);
        return createWinningLotto(lotto, bonusNumber);
    }

    private Lotto getWinningNumber() {
        LottoRequest lottoRequest = inputHandler.getWinningNumbers();
        LottoExtractor extractor = new LottoExtractor();
        List<Integer> numbers = extractor.extractLotto(lottoRequest.winningNumbers());
        return new Lotto(numbers);
    }

    private int getBonusNumber(Lotto lotto) {
        BonusNumberRequest bonusNumberRequest = inputHandler.getBonusNumber(lotto);
        return Integer.parseInt(bonusNumberRequest.number());
    }

    private WinningLotto createWinningLotto(Lotto lotto, int bonusNumber) {
        return WinningLotto.from(lotto, bonusNumber);
    }
}
