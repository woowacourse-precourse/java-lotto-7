package lotto.dto.request;

import java.util.List;

public record WinningLottoNumbersDTO(
        List<Integer> numbers
) {
    public static WinningLottoNumbersDTO of(List<Integer> numbers) {
        return new WinningLottoNumbersDTO(numbers);
    }
}
