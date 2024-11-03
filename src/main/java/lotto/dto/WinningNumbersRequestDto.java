package lotto.dto;

import java.util.List;

public record WinningNumbersRequestDto(List<Integer> mainNumber, Integer bonusNumber) {

}
