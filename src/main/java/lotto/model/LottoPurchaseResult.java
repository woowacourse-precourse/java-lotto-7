package lotto.model;

import java.util.List;

public record LottoPurchaseResult(List<List<Integer>> lottoTicketsNumbers, int amount) {
}
