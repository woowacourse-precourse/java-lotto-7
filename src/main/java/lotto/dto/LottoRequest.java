package lotto.dto;

import java.util.List;

public record LottoRequest(int purchaseAmount, List<LottoTicketDto> purchaseTickets, List<Integer> winningNumbers, int bonusNumber) {
}