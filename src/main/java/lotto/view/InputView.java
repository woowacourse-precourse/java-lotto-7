package lotto.view;

import java.util.Arrays;
import java.util.List;
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
        String number = reader.read();
        List<Integer> lottoNumbers = Arrays.stream(number.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .toList();
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        writer.writerLine("보너스 번호를 입력해 주세요.");
        return toInt(reader.read());
    }

    public void close() {
        reader.close();
    }

    private int toInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

}
