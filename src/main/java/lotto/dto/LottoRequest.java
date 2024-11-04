package lotto.dto;

import lotto.model.LottoTicket;

import java.util.List;

public record LottoRequest(int purchaseAmount, List<LottoTicket> purchaseTickets, List<Integer> winningNumbers, int bonusNumber) {
}