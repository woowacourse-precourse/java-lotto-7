package lotto.io.terminal;

import java.util.function.Supplier;
import lotto.io.preprocessor.IOPreprocessor;
import lotto.io.validator.InputValidatorFacade;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;

public class InputTerminal {

    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_DRAW_RESULT = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final Writer writer;
    private final Reader reader;

    private InputTerminal(final Writer writer, final Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public static class TerminalHolder {
        private static final InputTerminal INSTANCE = new InputTerminal(
                Writer.initiate(),
                Reader.initiate()
        );
    }

    public static InputTerminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    public Money readPurchaseAmount() {
        return retryTemplate(() -> {
            writer.simplePrint(ENTER_PURCHASE_AMOUNT);
            String input = reader.readInput();
            InputValidatorFacade.purchaseAmountValidators(input);
            return IOPreprocessor.stringToMoney(input);
        });
    }

    public Lotto readDrawResult() {
        return retryTemplate(() -> {
            writer.printWithNewLineBefore(ENTER_DRAW_RESULT);
            String input = reader.readInput();
            InputValidatorFacade.lottoNumbersValidators(input);
            return IOPreprocessor.stringToLotto(input);
        });
    }

    public Integer readBonusNumber(final Lotto lotto) {
        return retryTemplate(() -> {
            writer.printWithNewLineBefore(ENTER_BONUS_NUMBER);
            String input = reader.readInput();
            InputValidatorFacade.bonusNumberValidator(input, lotto);
            return IOPreprocessor.stringToInteger(input);
        });
    }

    private <T> T retryTemplate(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                writer.printErrorMessage(e.getMessage());
            }
        }
    }
}
