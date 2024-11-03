package lotto.ui;

import lotto.basic.StringPrinter;
import lotto.basic.StringReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserSettingReader {
    private final StringReader reader;
    private final StringPrinter printer;

    private final String BUYER_SEEDMONEY_PROMPT = "구입 금액을 입력해주세요.";
    private final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해주세요.";
    private final String NUMBERS_DELIMITER = ",";
    private final String NUMBERS_DELIMITER_REGEX =  Pattern.quote(NUMBERS_DELIMITER);

    public UserSettingReader(StringReader reader, StringPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public int readSeedMoney() {
        printer.print(BUYER_SEEDMONEY_PROMPT);
        return Integer.parseInt(reader.readLine());
    }

    public WinningNumberSettings readWinningNumbers() {
        return new WinningNumberSettings(
                readWinningNumbersElements(),
                readBonusNumber()
        );
    }

    private List<Integer> readWinningNumbersElements() {
        printer.print(WINNING_NUMBERS_PROMPT);
        return Arrays.stream(reader.readLine().split(NUMBERS_DELIMITER_REGEX))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
    }

    private int readBonusNumber() {
        printer.print(BONUS_NUMBER_PROMPT);
        return Integer.parseInt(reader.readLine());
    }
}
