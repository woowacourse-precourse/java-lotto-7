package lotto.dto.result;

import java.math.BigDecimal;

public record ProfitResult(int totalPurchaseAmount, int totalPrizeAmount, BigDecimal profitRate) {
}
