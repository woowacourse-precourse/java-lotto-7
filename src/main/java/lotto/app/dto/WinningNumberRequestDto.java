package lotto.app.dto;

import java.util.List;

public record WinningNumberRequestDto(List<Integer> winningNumbers, Integer bonusNumber) {

}
