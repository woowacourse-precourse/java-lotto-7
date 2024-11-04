package lotto.dto;

import java.util.List;

public record PurchaseResultResponse(
        int purchaseCount,
        List<List<Integer>> numbers
) {
}
