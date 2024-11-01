package lotto.service;

import static lotto.controller.ErrorMessages.INVALID_UNIT_OF_PAID_AMOUNT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.customer.Customer;
import lotto.model.dto.LottoDto;
import lotto.model.dto.ResultDto;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumberGenerator;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Rank;
import lotto.model.lotto.WinningLotto;

public class LottoService {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    public Customer sellLottoToNewCustomer(int paidAmount) {
        validatePaidAmount(paidAmount);

        int amountOfLottoTicket = paidAmount / PRICE_OF_LOTTO_TICKET;
        List<LottoTicket> tickets = issueLottoTickets(amountOfLottoTicket);

        return new Customer(paidAmount, tickets);
    }

    public List<LottoDto> getIssuedLottoNumbersOf(Customer customer) {
        List<Lotto> lottos = customer.getLottoTickets().stream()
                .map(LottoTicket::getLotto).toList();
        return lottos.stream().map(lotto -> new LottoDto(lotto.getNumbers())).toList();
    }

    public WinningLotto registerWinningNumbers(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public void determineRanks(Customer customer, WinningLotto winningLotto) {
        customer.determineRanksOfLottoTickets(winningLotto);
    }

    public ResultDto getResult(Customer customer) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();
        return ResultDto.from(customer.countRank(rankCounts), customer.calculateProfitRate());
    }

    private Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> rankCounts = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.DEFAULT)) {
                rankCounts.put(rank, 0);
            }
        }
        return rankCounts;
    }

    private List<LottoTicket> issueLottoTickets(int amountOfLottoTicket) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amountOfLottoTicket; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            tickets.add(new LottoTicket(lotto));
        }
        return tickets;
    }

    private void validatePaidAmount(int paidAmount) {
        if (paidAmount % PRICE_OF_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_OF_PAID_AMOUNT);
        }
    }
}
