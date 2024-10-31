package lotto.dto;

import java.util.List;

public record LottoCalculateRequest(int buyMoney, List<Integer> winningNumbers, int bonusNumber) {
    
}
