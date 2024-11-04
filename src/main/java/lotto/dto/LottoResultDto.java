package lotto.dto;

import java.util.Arrays;
import java.util.List;
import lotto.model.LottoPrize;
import lotto.model.LottoResult;

public record LottoResultDto(List<LottoPrizeDto> prizes, double rateOfReturn) {
    public LottoResultDto(LottoResult result) {
        this(toPrizeDto(result), result.rateOfReturn());
    }

    private static List<LottoPrizeDto> toPrizeDto(LottoResult result) {
        return Arrays.stream(LottoPrize.values())
                .map(p -> new LottoPrizeDto(p, result.prizeOf(p)))
                .toList();
    }

    @Override
    public List<LottoPrizeDto> prizes() {
        return List.copyOf(prizes);
    }
}
