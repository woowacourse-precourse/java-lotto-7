package lotto.ui;

import lotto.basic.StringPrinter;
import lotto.basic.StringReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserSettingReader {
    private static final String INVALID_INPUT_ERROR_MESSAGE = "잘못된 입력입니다.";
    private static final String BUYER_SEEDMONEY_PROMPT = "구입 금액을 입력해주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해주세요.";
    private static final String NUMBERS_DELIMITER = ",";
    private static final String NUMBERS_DELIMITER_REGEX =  Pattern.quote(NUMBERS_DELIMITER);

    private final StringReader reader;
    private final StringPrinter printer;

    public UserSettingReader(StringReader reader, StringPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public int readSeedMoney() {
        printer.print(BUYER_SEEDMONEY_PROMPT);
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE, e);
        }
    }

    public WinningNumberSettings readWinningNumbers() {
        return new WinningNumberSettings(
                readWinningNumbersElements(),
                readBonusNumber()
        );
    }

    private List<Integer> readWinningNumbersElements() {
        printer.print(WINNING_NUMBERS_PROMPT);
        try {
            return Arrays.stream(reader.readLine().split(NUMBERS_DELIMITER_REGEX))
                    .mapToInt(Integer::valueOf)
                    .boxed()
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE, e);
        }
    }

    private int readBonusNumber() {
        printer.print(BONUS_NUMBER_PROMPT);
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE, e);
        }
    }
}
