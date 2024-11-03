package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidInputException;
import lotto.view.input.ConsoleReader;
import lotto.view.input.Reader;
import lotto.view.output.ConsoleWriter;
import lotto.view.output.Writer;

public class InputView {

    private static final Reader DEFAULT_READER = new ConsoleReader();
    private static final Writer DEFAULT_WRITER = new ConsoleWriter();
    private static final String NUMBER_DELIMITER = ",";
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public InputView() {
        this(DEFAULT_READER, DEFAULT_WRITER);
    }

    public int inputPurchaseAmount() {
        writer.writerLine("구입금액을 입력해 주세요.");
        return toInt(reader.read());
    }

    public List<Integer> inputLottoNumbers() {
        writer.writerLine("당첨 번호를 입력해 주세요.");
        return readWinningNumbers(reader.read());
    }

    public int inputBonusNumber() {
        writer.writerLine("보너스 번호를 입력해 주세요.");
        return toInt(reader.read());
    }

    public void close() {
        reader.close();
    }

    private int toInt(String purchaseAmount) {
        validateNotEmpty(purchaseAmount);
        return parsePositiveInt(purchaseAmount);
    }

    private List<Integer> readWinningNumbers(String winningNumbers) {
        if (!winningNumbers.contains(NUMBER_DELIMITER)) {
            throw new InvalidInputException(InvalidInputException.NOT_MATCH_DELIMITER_ERROR);
        }
        return Arrays.stream(winningNumbers.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNotEmpty(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new InvalidInputException(InvalidInputException.EMPTY_INPUT_ERROR);
        }
    }

    private int parsePositiveInt(String purchaseAmount) {
        try {
            int value = Integer.parseInt(purchaseAmount);
            if (value <= 0) {
                throw new InvalidInputException(InvalidInputException.NEGATIVE_INPUT_ERROR);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InvalidInputException.NON_NUMERIC_INPUT_ERROR);
        }
    }

}
