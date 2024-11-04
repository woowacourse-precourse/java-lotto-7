package lotto.global.dto.response;

import java.util.Map;
import lotto.global.enums.WinningLottoRank;

public record LottoMatchResponseDTO(Map<WinningLottoRank, Integer> winningCount, Double rateOfReturn) {
}
