package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;

public class ConsoleInputHandler implements InputHandler {

    private final LottoConverter lottoConverter = new LottoConverter();

    @Override
    public int getLottoPurchaseFromUser() {
        return handleWithRetry(() -> {
            String userInput = Console.readLine();
            return lottoConverter.getLottoCount(userInput);
        });
    }

    @Override
    public List<Integer> getWinningNumbersFromUser() {
        return handleWithRetry(() -> {
            String userInput = Console.readLine();
            return lottoConverter.getWinningNumbers(userInput);
        });
    }

    @Override
    public int getBonusNumberFromUser(List<Integer> winningNumbers) {
        return handleWithRetry(() -> {
            String userInput = Console.readLine();
            return lottoConverter.getBonusNumber(userInput, winningNumbers);
        });
    }

    private <T> T handleWithRetry(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
