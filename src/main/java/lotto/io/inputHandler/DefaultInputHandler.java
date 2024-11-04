package lotto.io.inputHandler;

import java.util.List;
import lotto.io.reader.Reader;
import lotto.io.writer.Writer;

public class DefaultInputHandler implements InputHandler {

    private static final String PURCHASE_COST_DESCRIPTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_DESCRPTION = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_SPLITER = ",";
    private static final String BONUS_NUMBER_DESCRPTION = "보너스 번호를 입력해 주세요.";

    private final Reader reader;
    private final Writer writer;

    public DefaultInputHandler(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public int handlePurchaseCost() {
        writer.writeLine(PURCHASE_COST_DESCRIPTION);
        int purchaseCost = reader.readLineAsNumber();
        writer.writeLine("");
        return purchaseCost;
    }

    @Override
    public List<Integer> handleWinningNumbers() {
        writer.writeLine(WINNING_NUMBERS_DESCRPTION);
        List<Integer> winningNumbers = reader.readLineAsNumbers(WINNING_NUMBERS_SPLITER);
        writer.writeLine("");
        return winningNumbers;
    }

    @Override
    public int handleBonusNumber() {
        writer.writeLine(BONUS_NUMBER_DESCRPTION);
        int bonusNumber = reader.readLineAsNumber();
        writer.writeLine("");
        return bonusNumber;
    }
}
