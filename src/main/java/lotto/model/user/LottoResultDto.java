package lotto.model.user;

import java.util.List;
import java.util.Set;

public record LottoResultDto(List<Set<Integer>> lottoResults, int lotteryCount) {

    public static LottoResultDto from(LotteryMachine lotteryMachine) {
        return new LottoResultDto(
                lotteryMachine.getLottoResults(),
                lotteryMachine.getLotteryCount()
        );
    }
}
