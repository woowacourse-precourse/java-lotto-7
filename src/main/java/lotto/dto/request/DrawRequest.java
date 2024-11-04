package lotto.dto.request;

import java.util.List;

public record DrawRequest(
        List<List<Integer>> tickets,
        List<Integer> winningNumbers,
        Integer bonusNumber
) {
    public static DrawRequest of(List<List<Integer>> tickets, List<Integer> winningNumbers, Integer bonusNumber) {
        return new DrawRequest(tickets, winningNumbers, bonusNumber);
    }
}
