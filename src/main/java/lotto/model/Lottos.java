package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lottos {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private static final Integer WINNING_NUMBER_COUNT = 6;
    private static final String WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final String WINNING_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 %d개여야 합니다.";
    public Lottos(List<Lotto> lottos, final List<Integer> winningNumbers, final Integer bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateWinningCount(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);

        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    private void validateWinningNumbers(final List<Integer> winningNumbers){
        Set<Integer> winningNumberSet = new HashSet<>();
        for (Integer winningNumber : winningNumbers) {
            if(winningNumberSet.contains(winningNumber)){
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
            }

            winningNumberSet.add(winningNumber);
        }
    }

    private void validateBonusNumber(final List<Integer> winningNumbers, final Integer bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateWinningCount(final List<Integer> winningNumbers){
        if(winningNumbers.size() != WINNING_NUMBER_COUNT){
            throw new IllegalArgumentException(String.format(WINNING_NUMBER_COUNT_ERROR_MESSAGE, WINNING_NUMBER_COUNT));
        }
    }

}
