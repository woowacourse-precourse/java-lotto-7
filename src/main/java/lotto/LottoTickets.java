package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> tickets;
    private final Map<LottoPlace, Integer> resultTable = new HashMap<>();

    public LottoTickets(int numberOfTicket) {
        tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTicket; i++) {
            LottoTicket lottoTicket = new LottoTicket();
            tickets.add(lottoTicket);
        }
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public void decideLottoPlacesBy(Lotto lotto, int bonusNumber) {
        for (LottoTicket lottoTicket : tickets) {
            lottoTicket.decideLottoPlaceBy2(lotto, bonusNumber);
        }
    }

    public Map<LottoPlace, Integer> getLottoResultSummary() {
        List<LottoPlace> winningPlaces = LottoPlace.getWinningPlaces();

        for (LottoPlace place : winningPlaces) {
            resultTable.put(place, 0);
        }

        for (LottoTicket ticket : tickets) {
            resultTable.merge(ticket.getPlace(), 1, Integer::sum);
        }

        return resultTable;
    }

    public double getProfitRate() {

        double totalWinningMoney = 0;
        for (LottoTicket ticket : tickets) {
            totalWinningMoney += ticket.getWinningMoney();
        }

        double totalPayment = tickets.size() * 1000;
        double profitRate = (totalWinningMoney / totalPayment) * 100;

        return Math.round(profitRate * 100) / 100.0;

    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
