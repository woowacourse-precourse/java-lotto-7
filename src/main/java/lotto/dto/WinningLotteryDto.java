package lotto.dto;

import lotto.utils.LottoUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.LottoExceptionStatus.*;
import static lotto.properties.LottoProperties.LOTTO_NUMBER_END;
import static lotto.properties.LottoProperties.LOTTO_NUMBER_START;

public record WinningLotteryDto(
        List<Integer> winningLottery
) {

    public WinningLotteryDto {
        validate(winningLottery);
    }

    private void validate(List<Integer> winningLottery) {
        isGeneratedSixNumbers(winningLottery);
        isDuplicate(winningLottery);
        isOutOfRange(winningLottery);
    }

    private void isOutOfRange(List<Integer> winningLottery) {
        winningLottery.forEach(this::checkEach);
    }

    private void checkEach(Integer number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void isGeneratedSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static WinningLotteryDto from(String winningLottery) {
        return new WinningLotteryDto(LottoUtils.checkLottoNumberFormat(winningLottery));
    }
}
