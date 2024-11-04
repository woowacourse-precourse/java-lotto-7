package lotto.dto;

import java.util.List;

public record LottoInputDto(long purchaseAmount, List<Integer> winningNumber, int bonusNumber) {

}
