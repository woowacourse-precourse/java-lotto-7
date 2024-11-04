package lotto.dto;

import java.util.List;

public record WinningLottoDTO(List<Integer> numbers) {
    public static WinningLottoDTO from(List<String> numbers) {
        return new WinningLottoDTO(numbers.stream().map(Integer::valueOf).toList());
    }
}
