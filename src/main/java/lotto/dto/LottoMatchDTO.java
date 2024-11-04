package lotto.dto;

import lotto.model.Lottos;

public record LottoMatchDTO(Lottos purchaseLottos, WinningNumberDTO winningNumberDTO) {
}
