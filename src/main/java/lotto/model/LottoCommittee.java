package lotto.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LottoCommittee {

    private static final String ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자가 입력 되어야 합니다.";

    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MINIMUM_WINNING_OR_BONUS_NUMBER = 1;
    private static final int MAXIMUM_WINNING_OR_BONUS_NUMBER = 45;
    private static final int INITIAL_COUNT = 0;
    private static final int LOOP_START_INDEX = 0;
    private static final int DEFAULT_COUNT_ZERO = 0;
    private static final int ONE = 1;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void insertWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateWinningNumber();
    }

    public void insertBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
        validateBonusNumberDuplicate();
    }

    private void validateBonusNumberDuplicate() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE);
        }
    }

    private void validateBonusNumber() {
        if (bonusNumber < MINIMUM_WINNING_OR_BONUS_NUMBER || bonusNumber > MAXIMUM_WINNING_OR_BONUS_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE);
        }
    }

    private void validateWinningNumber() {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE);
        }
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_WINNING_OR_BONUS_NUMBER || winningNumber > MAXIMUM_WINNING_OR_BONUS_NUMBER) {
                throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE);
            }
        }
        if (new HashSet<>(winningNumbers).size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE);
        }
    }

    public Ranking calculateRanking(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int size = numbers.size();

        int matchingCount = INITIAL_COUNT;
        for (int i = LOOP_START_INDEX; i < size; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                matchingCount++;
            }
        }
        boolean isBonusNumberMatching = numbers.contains(bonusNumber);

        return Ranking.of(matchingCount, isBonusNumberMatching);
    }

    public HashMap<Ranking, Integer> calculateRanking(List<Lotto> lottos) {
        HashMap<Ranking, Integer> rankingCountMap = new HashMap<>();

        lottos.forEach(
                lotto -> {
                    Ranking ranking = calculateRanking(lotto);
                    rankingCountMap.put(ranking, rankingCountMap.getOrDefault(ranking, DEFAULT_COUNT_ZERO) + ONE);
                }
        );
        return rankingCountMap;
    }
}
