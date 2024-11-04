package lotto.service;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.enums.ErrorMessage;
import lotto.enums.Rank;
import lotto.model.Lotto;

public class UserLottoService {

    private static Set<String> numbers;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int SIZE_OF_DEFAULT_NUMBERS = 6;

    public void validateDefaultNumber(List<String> numbersToValidate) {
        validateEmpty(numbersToValidate);
        validateFormat(numbersToValidate);
        validateRange(numbersToValidate);
        validateSize(numbersToValidate);
        validateDuplicate(numbersToValidate);
    }

    public void validateBonusNumber(String bonusNumber) {
        validateEmptyBonus(bonusNumber);
        validateFormatBonus(bonusNumber);
        validateRangeBonus(bonusNumber);
        validateDuplicateBonus(bonusNumber);
    }

    private void validateDuplicate(List<String> numbersToValidate) {
        numbers = new HashSet<>(numbersToValidate);
        if (numbers.size() != numbersToValidate.size()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateSize(List<String> numbersToValidate) {
        if (numbersToValidate.size() != SIZE_OF_DEFAULT_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateEmpty(List<String> numbersToValidate) {
        if (numbersToValidate == null || numbersToValidate.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateRange(List<String> numbersToValidate) {
        numbersToValidate.stream()
            .map(Integer::parseInt)
            .filter(i -> i < LOTTO_START_NUMBER || i > LOTTO_END_NUMBER)
            .findAny()
            .ifPresent(invalid -> {
                throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_RANGE.getMessage());
            });
    }

    private void validateFormat(List<String> numbersToValidate) {
        try {
            numbersToValidate.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_FORMAT_OF_NUMBER.getMessage());
        }
    }

    private void validateDuplicateBonus(String bonusNumber) {
        numbers.add(bonusNumber);
        if (numbers.size() != SIZE_OF_DEFAULT_NUMBERS + 1) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateEmptyBonus(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateRangeBonus(String bonusNumber) {
        int parsedBonus = Integer.parseInt(bonusNumber);
        if (parsedBonus < LOTTO_START_NUMBER || parsedBonus > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    private void validateFormatBonus(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_FORMAT_OF_NUMBER.getMessage());
        }
    }

    public Map<Rank, Integer> calculateWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> statistics = initializeStatistics();

        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto.getNumbers(), winningNumbers, bonusNumber);
            if (rank != null) {
                statistics.put(rank, statistics.get(rank) + 1);
            }
        }

        return statistics;
    }

    private Map<Rank, Integer> initializeStatistics() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }

    private Rank getRank(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();

        boolean hasBonusNumber = numbers.contains(bonusNumber);

        if (matchCount == 6) return Rank.SIX;
        if (matchCount == 5) return hasBonusNumber ? Rank.FIVE_AND_BONUS : Rank.FIVE;
        if (matchCount == 4) return Rank.FOUR;
        if (matchCount == 3) return Rank.THREE;
        return null;
    }

    public int calculateTotalPrize(Map<Rank, Integer> statistics) {
        return statistics.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }

    public double calculateReturnRate(Map<Rank, Integer> statistics, int totalPurchaseAmount) {
        int totalPrize = calculateTotalPrize(statistics);
        return (totalPrize * 100.0) / totalPurchaseAmount;
    }
}
