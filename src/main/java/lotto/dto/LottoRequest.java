package lotto.dto;

import java.util.List;

public record LottoRequest(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
}