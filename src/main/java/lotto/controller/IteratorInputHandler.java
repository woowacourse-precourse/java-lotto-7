package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.converter.StringToIntConverter;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final InputTemplate inputTemplate;

    public IteratorInputHandler(InputView inputView, InputValidator inputValidator, InputTemplate inputTemplate) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.inputTemplate = inputTemplate;
    }

    public Money inputLottoPurchaseMoney() {
        return inputTemplate.execute(
                inputView::inputLottoPurchaseAmount,
                lottoPurchaseAmount -> {
                    inputValidator.validatePurchaseAmount(lottoPurchaseAmount);
                    return Money.from(Long.parseLong(lottoPurchaseAmount));
                }
        );
    }

    public WinningLotto inputWinningLotto() {
        Lotto lotto = inputWinningNumber();
        return inputTemplate.execute(
                inputView::inputBonusNumber,
                bonusNumber -> {
                    StringToIntConverter converter = new StringToIntConverter();
                    int bonus = converter.convert(bonusNumber);
                    return new WinningLotto(lotto, new Bonus(bonus));
                }
        );
    }

    private Lotto inputWinningNumber() {
        return inputTemplate.execute(
                inputView::inputWinningNumber,
                winningNumber -> {
                    StringToIntConverter converter = new StringToIntConverter();
                    List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                            .map(converter::convert)
                            .toList();
                    return new Lotto(winningNumbers);
                }
        );
    }
}
