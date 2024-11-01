package lotto.dto;

import java.util.List;

public record WinningSummary(List<String> winningDetails, List<WinningStat> WinningStats) {
}
