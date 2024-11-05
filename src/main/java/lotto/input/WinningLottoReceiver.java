package lotto.input;

import lotto.domain.Lotto;
import lotto.annotation.Retry;
import lotto.domain.WinningLotto;
import lotto.message.LottoMessage;
import lotto.message.MessagePrinter;
import lotto.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoReceiver implements Receiver<WinningLotto> {

    private final InputProvider inputProvider;
    private final Parser parser;

    public WinningLottoReceiver(InputProvider inputProvider, Parser parser) {
        this.inputProvider = inputProvider;
        this.parser = parser;
    }

    @Retry
    @Override
    public WinningLotto receiveWithMessage() {
        MessagePrinter.printMessage(LottoMessage.ENTER_WINNING_NUMBER);
        String[] numbers = parseInput(inputProvider.readLine());
        validateEmpty(numbers);
        validateNumbers(numbers);
        return new WinningLotto(new Lotto(toList(numbers)));
    }

    private String[] parseInput(String input) {
        return parser.parse(input);
    }

    private List<Integer> toList(String[] numbers) {
        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private void validateEmpty(String[] numbers) {
        for (String number : numbers) {
            validateEmpty(number);
        }
    }
}
