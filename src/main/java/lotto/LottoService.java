package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import enums.InputRegix;
import enums.Prize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public int getNumberOfTickets(String purchase) {
        if (!purchase.matches(InputRegix.PURCHASE.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 숫자여야 합니다.");
        }

        return Integer.parseInt(purchase) / 1000;
    }

    public List<List<Integer>> getTickets(int numberOfTickets) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(ticket);
            System.out.println(ticket);
        }

        return tickets;
    }

    public List<Integer> checkWinningNumber(String winningNumberBeforeCheck) {
        List<Integer> winningNumber = new ArrayList<>();

        for (String number : winningNumberBeforeCheck.split(",")) {
            if (!number.matches(InputRegix.LOTTO.getRegix())) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자여야 합니다.");
            }

            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public int checkBonusNumber(String bonusNumberBeforeCheck, List<Integer> winningNumber) {
        if (!bonusNumberBeforeCheck.matches(InputRegix.LOTTO.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자여야 합니다.");
        }

        int bonusNumber = Integer.parseInt(bonusNumberBeforeCheck);
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }

        return bonusNumber;
    }

    public HashMap<String, Integer> getInitialLottoResult() {
        HashMap<String, Integer> lottoResult = new HashMap<>();
        for (Prize rank : Prize.values()) {
            lottoResult.put(rank.name(), 0);
        }

        return lottoResult;
    }

    public int getNumberOfMatch(List<Integer> ticket, List<Integer> winningNumber) {
        int count = 0;
        for (int number : ticket) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public Prize getLottoRank(int NumberOfMatch, boolean hasBonusNumber) {
        if (NumberOfMatch == 6) {
            return Prize.FIRST;
        }

        if (NumberOfMatch == 5 && hasBonusNumber) {
            return Prize.SECOND;
        }

        if (NumberOfMatch == 5) {
            return Prize.THIRD;
        }

        if (NumberOfMatch == 4) {
            return Prize.FOURTH;
        }

        if (NumberOfMatch == 3) {
            return Prize.FIFTH;
        }

        return null;
    }

    public HashMap<String, Integer> assessLottoOutcome(HashMap<String, Integer> lottoResult,
            List<List<Integer>> tickets, List<Integer> winningNumber, int bonusNumber) {
        for (List<Integer> ticket : tickets) {
            int NumberOfMatch = getNumberOfMatch(ticket, winningNumber);
            boolean hasBonusNumber = ticket.contains(bonusNumber);
            Prize lottoRank = getLottoRank(NumberOfMatch, hasBonusNumber);

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

        return Math.round(rateOfReturn * 100.0) / 100.0;
    }
}
