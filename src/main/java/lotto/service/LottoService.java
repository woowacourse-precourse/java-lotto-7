package lotto.service;

import static lotto.controller.ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoTicket;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;

public class LottoService {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    public List<LottoTicket> purchase(int paidAmount) {
        if (paidAmount % PRICE_OF_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_PAID_AMOUNT);
        }

        int amountOfLottoTicket = paidAmount / PRICE_OF_LOTTO_TICKET;

        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < amountOfLottoTicket; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            tickets.add(new LottoTicket(lotto));
        }

        return tickets;
    }

    public List<LottoDto> getLottoNumbersOfCustomer(Customer customer) {
        List<Lotto> lottos = customer.getLottoTickets().stream()
                .map(LottoTicket::getLotto).toList();
        return lottos.stream().map(lotto -> new LottoDto(lotto.getNumbers())).toList();
    }

    public WinningLotto registerWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public void determineRanks(Customer customer, WinningLotto winningLotto) {
        customer.determineRanks(winningLotto);
    }

    public ResultDto getResult(Customer customer) {
        Map<Rank, Integer> rankCounts = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.DEFAULT)) {
                rankCounts.put(rank, 0);
            }
        }

        return ResultDto.from(customer.countRank(rankCounts), customer.calculateProfitRate());
    }
}
