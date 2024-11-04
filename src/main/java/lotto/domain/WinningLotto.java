package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.error.ErrorMessage;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final WinnerResult winnerResult;

    public WinningLotto(List<Integer> numbers, int bonusNumber, WinnerResult winnerResult) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        this.winnerResult = winnerResult;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinnerResult getWinnerResult() {
        return winnerResult;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    public void findWinningLottery(LottoGroup lottoGroup, WinningLotto winningLotto) {
        List<Lotto> lottos = lottoGroup.getLottoGroup();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();

        for (Lotto lotto : lottos) {
            findEachWinningLottery(lotto, winningLottoNumbers);
        }
    }

    public void findEachWinningLottery(Lotto lotto, List<Integer> winningLottoNumbers) {
        List<Integer> duplicatedNumbers = lotto.getNumbers().stream()
                .filter(old -> winningLottoNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .toList();

        int duplicatedSize = duplicatedNumbers.size();
        boolean hasBonusNumber = duplicatedNumbers.contains(bonusNumber);
        increaseAmountBySize(duplicatedSize, hasBonusNumber);
    }

    public void increaseAmountBySize(int duplicatedSize, boolean hasBonusNumber) {
        checkThreeMatched(duplicatedSize);
        checkFourMatched(duplicatedSize);
        checkFiveBonusMatched(duplicatedSize, hasBonusNumber);
        checkFiveMatched(duplicatedSize, hasBonusNumber);
        checkSixMatched(duplicatedSize);
    }

    private void checkThreeMatched(int duplicatedSize) {
        if (duplicatedSize == 3) {
            winnerResult.addMatchedAmount(Winners.THREE_MATCHED);
        }
    }

    private void checkFourMatched(int duplicatedSize) {
        if (duplicatedSize == 4) {
            winnerResult.addMatchedAmount(Winners.FOUR_MATCHED);
        }
    }

    private void checkFiveBonusMatched(int duplicatedSize, boolean hasBonusNumber) {
        if (duplicatedSize == 5 && hasBonusNumber) {
            winnerResult.addMatchedAmount(Winners.FIVE_BONUS_MATCHED);
        }
    }

    private void checkFiveMatched(int duplicatedSize, boolean hasBonusNumber) {
        if (duplicatedSize == 5 && !hasBonusNumber) {
            winnerResult.addMatchedAmount(Winners.FIVE_MATCHED);
        }
    }

    private void checkSixMatched(int duplicatedSize) {
        if (duplicatedSize == 6) {
            winnerResult.addMatchedAmount(Winners.SIX_MATCHED);
        }
    }


}
