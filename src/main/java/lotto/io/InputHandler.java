package lotto.io;

import java.util.List;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

public class InputHandler {

    private static final String PURCHASE_COST_DESCRIPTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_DESCRPTION = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_SPLITER = ",";
    private static final String BONUS_NUMBER_DESCRPTION = "보너스 번호를 입력해 주세요.";

    private final Reader reader;
    private final Writer writer;

    public InputHandler(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public int handlePurchaseCost() {
        writer.writeLine(PURCHASE_COST_DESCRIPTION);
        return reader.readLineAsNumber();
    }

    public List<Integer> handleWinningNumbers() {
        writer.writeLine(WINNING_NUMBERS_DESCRPTION);
        return reader.readLineAsNumbers(WINNING_NUMBERS_SPLITER);
    }

    public int handleBonusNumber() {
        writer.writeLine(BONUS_NUMBER_DESCRPTION);
        return reader.readLineAsNumber();
    }
}
