package lotto.dto;

import lotto.LottoPrize;

import java.util.Map;

public record LottoResult(Map<LottoPrize, Integer> prizeResult, int userBuyMoney) {
}
