package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.exception.MoneyExceptionType;

public class LottoService {
    private static final int LOTTO_PRIZE = 1000;

    Money money;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private int numOfLottos;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningNumber;

    public void checkAndConvertInputMoney(String moneyInput) throws IllegalArgumentException {
        if (moneyInput.isBlank()) {
            throw new IllegalArgumentException(MoneyExceptionType.EMPTY_INPUT_MONEY.getMessage());
        }

        try {
            money = new Money(Integer.parseInt(moneyInput.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyExceptionType.NOT_INTEGER_MONEY.getMessage());
        }

        numOfLottos = money.getMoney() / LOTTO_PRIZE;
    }

    public void checkAndConvertInputWinningNumber(String winningNumberInput) {
        List<String> parsedWinningNumberInput = splitWinningNumberInput(winningNumberInput);

        List<Integer> winningNumberConvertedToInt = new ArrayList<>();
        for (String element : parsedWinningNumberInput) {
            winningNumberConvertedToInt.add(Integer.parseInt(element));
        }
        winningNumber = new Lotto(winningNumberConvertedToInt);
    }

    private List<String> splitWinningNumberInput(String winningNumberInput) {
        return Stream.of(winningNumberInput.split(",", -1))
                .map(String::trim)
                .toList();
    }

    public List<Lotto> generateLottos() {
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(randomNumberGenerator.generateLottoNumbers());
        }
        return lottos;
    }
}
