package lotto.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.model.enums.WinningType;

public class Lottos {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Map<WinningType, Integer> winningResult = new HashMap<>();
    private final Integer bonusNumber;

    private static final Integer WINNING_NUMBER_COUNT = 6;
    private static final Integer WINNING_NUMBER_MIN = 1;
    private static final Integer WINNING_NUMBER_MAX = 45;
    private static final String WINNING_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 %d부터 %d 사이의 값이여야 합니다.";
    private static final String WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String WINNING_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 %d개여야 합니다.";

    public Lottos(List<Lotto> lottos, final List<Integer> winningNumbers, final Integer bonusNumber) {
        validateWinningNumbersDuplicate(winningNumbers);
        validateWinningCount(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        validateWinningNumbersRange(winningNumbers);

        initWinningResult();

        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void initWinningResult() {
        for (WinningType winningType : WinningType.values()) {
            winningResult.put(winningType, 0);
        }
    }

    public Map<WinningType, Integer> getWinningResult() {
        checkWinningResult();
        return winningResult;
    }

    public Long getTotalPrize(){
        Long totalPrize = 0L;

        for (WinningType winningType : winningResult.keySet()) {
            totalPrize += winningType.getPrize() * winningResult.get(winningType);
        }

        return totalPrize;
    }

    private void checkWinningResult() {
        for (Lotto lotto : lottos) {
            WinningType winningType = lotto.checkWinningNumbers(winningNumbers, bonusNumber);
            winningResult.put(winningType, winningResult.getOrDefault(winningType, 0) + 1);
        }
    }

    private void validateWinningNumbersDuplicate(final List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>();
        for (Integer winningNumber : winningNumbers) {
            checkDuplicateNumber(winningNumber, winningNumberSet);
        }
    }

    private void checkDuplicateNumber(final Integer number, final Set<Integer> numberSet){
        if (!numberSet.contains(number)) {
            numberSet.add(number);
            return;
        }
        throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
    }


    private void validateWinningNumbersRange(final List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            validateRange(winningNumber);
        }
    }

    private void validateRange(Integer number) {
        if ((number > WINNING_NUMBER_MAX) || (number < WINNING_NUMBER_MIN)) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBER_RANGE_ERROR_MESSAGE, WINNING_NUMBER_MIN, WINNING_NUMBER_MAX));
        }
    }

    private void validateBonusNumber(final List<Integer> winningNumbers, final Integer bonusNumber) {
        validateRange(bonusNumber);

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateWinningCount(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(WINNING_NUMBER_COUNT_ERROR_MESSAGE, WINNING_NUMBER_COUNT));
        }
    }
}
