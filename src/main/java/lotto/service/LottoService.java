package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Money;
import lotto.exception.MoneyExceptionType;

public class LottoService {
    private static final int LOTTO_PRIZE = 1000;

    Money money;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private int numOfLottos;
    private List<List<Integer>> lottos = new ArrayList<>();

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

    public List<List<Integer>> generateLottos() {
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(randomNumberGenerator.generateLottoNumbers());
        }
        return lottos;
    }
}
