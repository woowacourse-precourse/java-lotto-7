package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class InputController {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final InputTemplate inputTemplate;

    public InputController(InputView inputView, InputValidator inputValidator, InputTemplate inputTemplate) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.inputTemplate = inputTemplate;
    }

    public Money inputLottoPurchaseMoney() {
        return inputTemplate.execute(
                inputView::inputLottoPurchaseAmount,
                lottoPurchaseAmount -> {
                    inputValidator.validatePurchaseAmount(lottoPurchaseAmount);
                    return Money.from(lottoPurchaseAmount);
                }
        );
    }

    public WinningLotto inputWinningLotto() {
        Lotto lotto = inputWinningNumber();
        return inputTemplate.execute(
                inputView::inputBonusNumber,
                bonusNumber -> {
                    int bonus = Integer.parseInt(bonusNumber);
                    return new WinningLotto(lotto, new Bonus(bonus));
                }
        );
    }

    private Lotto inputWinningNumber() {
        return inputTemplate.execute(
                inputView::inputWinningNumber,
                winningNumber -> {
                    List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                            .map(Integer::valueOf)
                            .toList();
                    return new Lotto(winningNumbers);
                }
        );
    }
}
