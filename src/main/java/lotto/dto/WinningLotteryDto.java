package lotto.dto;

import java.util.Arrays;
import java.util.List;

public record WinningLotteryDto(
        List<Integer> winningLottery
) {
    public static WinningLotteryDto from(String winningLottery){
        return new WinningLotteryDto(Arrays.stream(winningLottery.split(","))
                .map(Integer::parseInt)
                .toList());
    }
}
