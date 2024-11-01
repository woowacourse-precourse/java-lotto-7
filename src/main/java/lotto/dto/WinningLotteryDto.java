package lotto.dto;

import lotto.exception.LottoExceptionStatus;

import java.util.Arrays;
import java.util.List;

public record WinningLotteryDto(
        List<Integer> winningLottery
) {

    public WinningLotteryDto {
        validate(winningLottery);
    }

    private void validate(List<Integer> winningLottery){
        winningLottery.forEach( number -> {
                    if(isOutOfRange(number))
                        throw new IllegalArgumentException(LottoExceptionStatus.INVALID_WINNING_NUMBER_RANGE.getMessage());
                });
    }

    private boolean isOutOfRange(int number){
        return number < 1 || number > 45;
    }

    public static WinningLotteryDto from(String winningLottery){
        return new WinningLotteryDto(Arrays.stream(winningLottery.split(","))
                .map(Integer::parseInt)
                .toList());
    }
}
