package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.exception.BonusExceptionType;
import lotto.exception.LottoExceptionType;
import lotto.exception.MoneyExceptionType;

public class LottoService {
    private static final long LOTTO_PRIZE = 1000;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final LottoResultChecker lottoResultChecker = new LottoResultChecker();

    private Money money;
    private long numOfLottos;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningNumber;
    private Bonus bonusNumber;

    public void checkAndConvertInputMoney(String moneyInput) throws IllegalArgumentException {
        if (moneyInput.isBlank()) {
            throw new IllegalArgumentException(MoneyExceptionType.EMPTY_INPUT_MONEY.getMessage());
        }

        try {
            money = new Money(Long.parseLong(moneyInput.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyExceptionType.NOT_INTEGER_MONEY.getMessage());
        }

        numOfLottos = money.getMoney() / LOTTO_PRIZE;
    }

    public void checkAndConvertInputWinningNumber(String winningNumberInput) throws IllegalArgumentException {
        if (winningNumberInput.isBlank()) {
            throw new IllegalArgumentException(LottoExceptionType.EMPTY_INPUT_WINNING_NUMBER.getMessage());
        }

        List<String> parsedWinningNumberInput = splitWinningNumberInput(winningNumberInput);
        try {
            List<Integer> winningNumberConvertedToInt = parsedWinningNumberInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            winningNumber = new Lotto(winningNumberConvertedToInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionType.NOT_INTEGER_WINNING_NUMBER.getMessage());
        }
    }

    private List<String> splitWinningNumberInput(String winningNumberInput) {
        return Stream.of(winningNumberInput.split(",", -1))
                .map(String::trim)
                .toList();
    }

    public void checkAndConvertInputBonusNumber(String bonusNumberInput) throws IllegalArgumentException {
        if (bonusNumberInput.isBlank()) {
            throw new IllegalArgumentException(BonusExceptionType.EMPTY_INPUT_BONUS_NUMBER.getMessage());
        }

        try {
            int bonus = Integer.parseInt(bonusNumberInput.trim());
            if (winningNumber.getNumbers().contains(bonus)) {
                throw new IllegalArgumentException(BonusExceptionType.DUPLICATED_BONUS_NUMBER.getMessage());
            }

            bonusNumber = new Bonus(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BonusExceptionType.NOT_INTEGER_BONUS_NUMBER.getMessage());
        }
    }

    public List<Lotto> generateLottos() {
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(randomNumberGenerator.generateLottoNumbers());
        }
        return lottos;
    }

    public Map<List<Integer>, Double> getLottoStatistics() {
        lottoResultChecker.lottoChecker(lottos, winningNumber, bonusNumber);
        return Map.of(getLottoResult(), getLottoRateOfReturn());
    }

    private List<Integer> getLottoResult() {
        return lottoResultChecker.getResult();
    }

    private double getLottoRateOfReturn() {
        return (double) lottoResultChecker.getPrize() / money.getMoney() * 100;
    }
}
