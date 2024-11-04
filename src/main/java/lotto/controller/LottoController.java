package lotto.controller;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoDto;
import lotto.model.Game;
import lotto.model.WinningNumberConverter;
import lotto.model.purchase.PurchaseAmountConverter;
import lotto.view.View;

public class LottoController {
    private final View view;
    private final Game game;

    public LottoController(View view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() {
        handleLottoPurchase();
        displayIssuedLottos();
        handleInputWinningNumbers();
    }

    private <T> void executeWithRetry(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                view.displayException(e.getMessage());
            }
        }
    }

    private void handleLottoPurchase() {
        executeWithRetry(this::purchaseLottos);
    }

    private void purchaseLottos() {
        String input = view.promptPurchaseAmount();
        int amount = PurchaseAmountConverter.convert(input);
        game.purchaseLottos(amount);
    }

    private void displayIssuedLottos() {
        List<LottoDto> lottoDtos = game.getIssuedLottos().stream()
                .map(LottoDto::of)
                .toList();
        view.displayIssuedLottos(new IssuedLottosDto(lottoDtos));
    }

    private void handleInputWinningNumbers() {
        executeWithRetry(this::inputWinningNumbers);
    }

    private void inputWinningNumbers() {
        String input = view.promptWinningNumbers();
        List<Integer> winningNumbers = WinningNumberConverter.convert(input);
        game.setWinningNumber(winningNumbers);
    }
}
