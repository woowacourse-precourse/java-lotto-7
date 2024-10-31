package lotto.dto.response;

import java.util.List;

public record PurchaseLottosResponse(
        Integer count,
        List<List<Integer>> allLottosNumbers
) {
    public static PurchaseLottosResponse of(Integer count, List<List<Integer>> lottos) {
        return new PurchaseLottosResponse(count, lottos);
    }
}
