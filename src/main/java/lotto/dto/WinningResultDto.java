package lotto.dto;

import lotto.model.WinningType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record WinningResultDto(Map<WinningType, Integer> winningResult) {
    public List<Integer> getWinningTypeCounts() {
        return List.of(WinningType.FIFTH, WinningType.FOURTH, WinningType.THIRD, WinningType.SECOND, WinningType.FIRST)
                .stream()
                .map(type -> winningResult.getOrDefault(type, 0))
                .collect(Collectors.toList());
    }
}