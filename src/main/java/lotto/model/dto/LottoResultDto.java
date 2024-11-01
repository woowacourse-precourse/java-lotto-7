package lotto.model.dto;

import java.util.List;
import lotto.model.LotteryMachine;

public record LottoResultDto(List<String> lottoResult, int lotteryCount) {

    public static LottoResultDto from(LotteryMachine lotteryMachine) {
        return new LottoResultDto(
                lotteryMachine.getLottoResult(),
                lotteryMachine.getLotteryCount()
        );
    }
}
