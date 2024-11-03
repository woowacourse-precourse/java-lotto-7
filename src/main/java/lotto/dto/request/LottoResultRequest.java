package lotto.dto.request;

import java.util.List;

public record LottoResultRequest(
        List<Integer> winningNumbers,
        int bonusNumber
) {
    public static LottoResultRequest of(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResultRequest(winningNumbers, bonusNumber);
    }
}