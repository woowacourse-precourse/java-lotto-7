package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoPrizeDto;
import lotto.dto.WinningLottoDto;
import lotto.message.ExceptionMessage;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        Set<Integer> forValidateDuplication = new HashSet<>();
        for (int number : numbers) {
            validateNumberAreaOf(number, ExceptionMessage.WINNING_NUMBER_AREA_EXCEPTION);
            validateNumberDuplication(forValidateDuplication, number,
                    ExceptionMessage.WINNING_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_LENGTH_EXCEPTION);
        }
    }

    private void validateNumberAreaOf(int number, String message) {
        boolean isInvalidNumberArea = number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
        if (isInvalidNumberArea) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateNumberDuplication(Set<Integer> forValidateDuplication, int number, String message) {
        boolean isDuplicated = !forValidateDuplication.add(number);
        if (isDuplicated) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumberAreaOf(bonusNumber, ExceptionMessage.BONUS_NUMBER_AREA_EXCEPTION);
        Set<Integer> forValidateDuplication = new HashSet<>(numbers);
        validateNumberDuplication(forValidateDuplication, bonusNumber,
                ExceptionMessage.BONUS_NUMBER_DUPLICATION_EXCEPTION);
    }

    public WinningLottoDto generateWinningLotto(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        return new WinningLottoDto(numbers, bonusNumber);
    }

    public LottoPrizeDto matchLottoNumbers(WinningLottoDto winningLottoDto) {
        List<Integer> winningNumbers = winningLottoDto.getWinningNumbers();
        int bonusNumber = winningLottoDto.getBonusNumber();
        Set<Integer> forMatchNumber = new HashSet<>(numbers);
        boolean matchBonusNumber = !forMatchNumber.add(bonusNumber);
        int matchCount = countMatches(winningNumbers, forMatchNumber);
        return getRank(matchCount, matchBonusNumber);
    }

    private int countMatches(List<Integer> winningNumbers, Set<Integer> forMatchNumber) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (!forMatchNumber.add(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private LottoPrizeDto getRank(int matchCount, boolean matchBonusNumber) {
        LottoPrizeDto rank = new LottoPrizeDto(LottoPrize.NO_RANK);
        isFirstRank(matchCount, rank);
        isSecondOrThird(matchCount, matchBonusNumber, rank);
        isFourth(matchCount, rank);
        isFifth(matchCount, rank);
        return rank;
    }

    private void isFirstRank(int matchCount, LottoPrizeDto rank) {
        if (matchCount == 6) {
            rank.setLottoPrize(LottoPrize.FIRST);
        }
    }

    private void isSecondOrThird(int matchCount, boolean matchBonusNumber, LottoPrizeDto rank) {
        if (matchCount == 5) {
            rank.setLottoPrize(LottoPrize.THIRD);
            isSecond(matchBonusNumber, rank);
        }
    }

    private void isSecond(boolean matchBonusNumber, LottoPrizeDto rank) {
        if (matchBonusNumber) {
            rank.setLottoPrize(LottoPrize.SECOND);
        }
    }

    private void isFourth(int matchCount, LottoPrizeDto rank) {
        if (matchCount == 4) {
            rank.setLottoPrize(LottoPrize.FOURTH);
        }
    }

    private void isFifth(int matchCount, LottoPrizeDto rank) {
        if (matchCount == 3) {
            rank.setLottoPrize(LottoPrize.FIFTH);
        }
    }
}
