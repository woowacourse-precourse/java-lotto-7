package lotto.dto;

import java.util.List;

public class WinningLottoNumbersDto {
    private final List<Integer> winningLottoNumbers;

    public WinningLottoNumbersDto(List<Integer> getNumbers) {
        winningLottoNumbers = getNumbers;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers.stream().toList();
    }
}
