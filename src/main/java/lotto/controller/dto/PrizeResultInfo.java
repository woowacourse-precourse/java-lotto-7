package lotto.controller.dto;

import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

public record PrizeResultInfo(
        String condition,
        String prize,
        Integer count
) {
    public static PrizeResultInfo from(Rank rank, Prize prize, Integer count) {
        return new PrizeResultInfo(rank.getMessage(), prize.getMessage(), count);
    }
}
