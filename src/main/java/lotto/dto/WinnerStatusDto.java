package lotto.dto;

import lotto.domain.WinnerStatus;

public record WinnerStatusDto(WinnerStatus winnerStatus, String message) {
}
