package lotto.dto;

import lotto.model.WinningResult;
import lotto.model.WinningType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record WinningResultDto(WinningResult winningResult) {
    public List<Integer> getWinningTypeCounts() {
        return Stream.of(WinningType.FIFTH, WinningType.FOURTH, WinningType.THIRD, WinningType.SECOND, WinningType.FIRST)
                .map(winningResult::getCount)
                .collect(Collectors.toList());
    }
}