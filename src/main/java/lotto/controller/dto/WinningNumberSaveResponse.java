package lotto.controller.dto;

import lotto.domain.WinningNumber;

public record WinningNumberSaveResponse(int winningNumberIndex, WinningNumber winningNumber) {
}