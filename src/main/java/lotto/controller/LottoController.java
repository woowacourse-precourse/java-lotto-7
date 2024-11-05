package lotto.controller;

import lotto.collection.WinningNumber;
import lotto.domain.LottoResult;
import lotto.service.LottoService;

public class LottoController {
    // 싱글톤 패턴
    private static final LottoController instance = new LottoController();
    private final LottoService lottoService = LottoService.getInstance();

    protected LottoController() {
    }

    public static LottoController getInstance() {
        return instance;
    }

    public WinningNumber getWinningNumbers() {
        return lottoService.getWinningNumbers();
    }

    public LottoResult getBonusNumbers(WinningNumber winningNumbers) {
        return lottoService.getBonusNumbers(winningNumbers);
    }
}
