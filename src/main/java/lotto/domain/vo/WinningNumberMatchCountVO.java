package lotto.domain.vo;

import lotto.domain.lottery.Lottery;

public record WinningNumberMatchCountVO(Lottery lottery, Integer count) {
}
