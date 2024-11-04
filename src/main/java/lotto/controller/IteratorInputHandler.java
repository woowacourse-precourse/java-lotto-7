package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.converter.Converter;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class IteratorInputHandler {

    private static final String INPUT_WINNING_NUMBER_DELIMITER = ",";

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final IteratorInputTemplate iteratorInputTemplate;
    private final Converter<String, Integer> stringToIntConverter;

    public IteratorInputHandler(InputView inputView,
                                InputValidator inputValidator,
                                IteratorInputTemplate iteratorInputTemplate,
                                Converter<String, Integer> stringToIntConverter) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.iteratorInputTemplate = iteratorInputTemplate;
        this.stringToIntConverter = stringToIntConverter;
    }

    public Money inputLottoPurchaseMoney() {
        return iteratorInputTemplate.execute(
                inputView::inputLottoPurchaseAmount,
                lottoPurchaseAmount -> {
                    inputValidator.validatePurchaseAmount(lottoPurchaseAmount);
                    return Money.from(Long.parseLong(lottoPurchaseAmount.trim()));
                }
        );
    }

    public WinningLotto inputWinningLotto() {
        Lotto lotto = inputWinningNumber();
        return iteratorInputTemplate.execute(
                inputView::inputBonusNumber,
                bonusNumber -> {
                    int bonus = stringToIntConverter.convert(bonusNumber);
                    return new WinningLotto(lotto, new Bonus(bonus));
                }
        );
    }

    private Lotto inputWinningNumber() {
        return iteratorInputTemplate.execute(
                inputView::inputWinningNumber,
                winningNumber -> {
                    List<Integer> winningNumbers = Stream.of(winningNumber.split(INPUT_WINNING_NUMBER_DELIMITER))
                            .map(stringToIntConverter::convert)
                            .toList();
                    return new Lotto(winningNumbers);
                }
        );
    }
}
