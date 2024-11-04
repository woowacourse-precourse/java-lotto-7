package lotto.dto.request;

import java.util.List;

public record LottoMatchRequest(List<Integer> numbers, int bonusNumber) {
}
