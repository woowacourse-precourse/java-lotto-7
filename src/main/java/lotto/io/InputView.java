package lotto.io;

import java.util.function.Supplier;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinnerLotto;
import lotto.error.ErrorCode;

public class InputView implements AutoCloseable {

    private static final Reader DEFAULT_READER = new ConsoleReader();
    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public InputView() {
        this.reader = DEFAULT_READER;
    }

    private String readLine() {
        String input = reader.readLine();
        validate(input);
        return input;
    }

    private static void printReInput(IllegalArgumentException ex) {
        System.out.flush();
        System.out.println(ex.getMessage());
        System.out.println("다시 입력하세요.");
    }

    private static void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.BLANK_INPUT_MESSAGE.getMessage());
        }
    }

    private <T> T retryInput(String prompt, Supplier<T> inputSupplier) {
        System.out.println(prompt);
        while (true) {
            try {
                T result = inputSupplier.get();
                System.out.println();
                return result;
            } catch (IllegalArgumentException ex) {
                printReInput(ex);
            }
        }
    }

    public PurchaseAmount inputPurchaseAmount() {
        return retryInput("구입금액을 입력해 주세요.", () -> new PurchaseAmount(readLine()));
    }

    public WinnerLotto inputWinningNumbers() {
        return retryInput("당첨 번호를 입력해 주세요.", () -> WinnerLotto.from(readLine()));
    }

    public WinnerLotto inputBonusNumbers(WinnerLotto winnerLotto) {
        return retryInput("보너스 번호를 입력해 주세요.", () -> winnerLotto.addBonusNumber(readLine()));
    }

    @Override
    public void close() {
        reader.close();
    }
}
