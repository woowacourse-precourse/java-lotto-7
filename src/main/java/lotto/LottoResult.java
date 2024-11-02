package lotto;

import lotto.constant.WinningCondition;

public record LottoResult(WinningCondition winningCondition, int conditionCount) {
}
