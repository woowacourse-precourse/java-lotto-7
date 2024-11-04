package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import enums.Prize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    public List<List<Integer>> getTickets(int numberOfTickets) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(ticket);
            System.out.println(ticket.stream().sorted().collect(Collectors.toList()));
        }

        return tickets;
    }

    public HashMap<String, Integer> getInitialLottoResult() {
        HashMap<String, Integer> lottoResult = new HashMap<>();
        for (Prize rank : Prize.values()) {
            lottoResult.put(rank.name(), 0);
        }

        return lottoResult;
    }

    public HashMap<String, Integer> assessLottoOutcome(HashMap<String, Integer> lottoResult,
            List<List<Integer>> tickets, Lotto winningNumber, int bonusNumber) {
        for (List<Integer> ticket : tickets) {
            boolean hasBonusNumber = ticket.contains(bonusNumber);
            Prize lottoRank = winningNumber.getLottoRank(ticket, hasBonusNumber);

            if (lottoRank != null) {
                lottoResult.put(lottoRank.name(), lottoResult.get(lottoRank.name()) + 1);
            }
        }

        return lottoResult;
    }

    public double getRateOfReturn(Map<String, Integer> lottoResult, int numberOfTickets) {
        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            totalPrize += prize.getMoney() * lottoResult.get(prize.name());
        }
        double rateOfReturn = totalPrize / (numberOfTickets * 1000.0) * 100;

        return Math.round(rateOfReturn * 10.0) / 10.0;
    }
}
