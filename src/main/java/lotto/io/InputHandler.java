package lotto.io;

import static lotto.constants.InputMessages.READ_BONUS_NUMBER;
import static lotto.constants.InputMessages.READ_BUY_AMOUNT;
import static lotto.constants.InputMessages.READ_WINNING_NUMBER;

import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

public class InputHandler {

    private final Reader reader;
    private final Writer writer;
    private final InputValidator validator;

    public InputHandler(Reader reader, Writer writer, InputValidator validator) {
        this.reader = reader;
        this.writer = writer;
        this.validator = validator;
    }

    public long readBuyAmount() {
        writer.write(READ_BUY_AMOUNT);
        String buyAmount = reader.readLine();
        return validator.validateBuyAmount(buyAmount);
    }

    public String readWinningNumbers() {
        writer.write(READ_WINNING_NUMBER);
        String winningNumbers = reader.readLine();
        validator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public int readBonusNumber() {
        writer.write(READ_BONUS_NUMBER);
        String bonusNumber = reader.readLine();
        return validator.validateBonusNumber(bonusNumber);
    }
}
