package lotto.dto;

import java.math.BigDecimal;

public record ProfitResult(int totalPurchaseAmount, int totalPrizeAmount, BigDecimal profitRate) {
}
