package lotto.controller;

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

    public void getPurchaseLottoTickets(int userId) {
        lottoService.getLottoTickets(userId);
        lottoService.displayPurchaseLottoTickets(userId);
    }

    public void getWinningNumbers(int userId) {
        lottoService.getWinningNumbers(userId);
    }
}
