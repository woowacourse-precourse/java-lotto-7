package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {

    public static final int TO_MAKE_PERCENTAGE = 100;
    private final int money;
    private final int ticketCount;
    private final List<Lotto> tickets;

    public Machine(int money) {
        this.money = money;
        this.ticketCount = countTickets(money);
        this.tickets = makeTickets();
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    int countTickets(int money) {
        return money / 1000;
    }

    List<Lotto> makeTickets() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }

        return lottos;
    }

    private List<Integer> generateNumbers() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return integers.stream()
                .sorted()
                .toList();
    }

    public Map<String, Integer> getResult(WinningNumbers winningNumbers) {
        Lotto prizeNumber = winningNumbers.getPrizeNumber();
        int bonusNumber = winningNumbers.getBonusNumber();

        return getCountMatchResult(prizeNumber, bonusNumber);
    }

    private Map<String, Integer> getCountMatchResult(Lotto prizeNumber, int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        boolean isBonusNumberMatch = false;

        for (Lotto ticket : tickets) {
            int matchCount = checkPrizeNumberMatch(ticket, prizeNumber);
            if (matchCount == 5) {
                isBonusNumberMatch = checkBonusNumberMatch(bonusNumber, prizeNumber);
            }
            String matchCountResult = checkMatchCount(matchCount, isBonusNumberMatch);

            if (!result.containsKey(matchCountResult)) {
                result.put(matchCountResult, 1);
            } else {
                result.put(matchCountResult, result.get(matchCountResult) + 1);
            }
        }

        return result;
    }

    private String checkMatchCount(int matchCount, boolean isBonusNumberMatch) {
        if (matchCount == 6) {
            return Match.SIX_MATCH.name();
        } else if (matchCount == 5 && isBonusNumberMatch) {
            return Match.FIVE_AND_BONUS_MATCH.name();
        } else if (matchCount == 5) {
            return Match.FIVE_MATCH_ONLY.name();
        } else if (matchCount == 4) {
            return Match.FOUR_MATCH.name();
        } else if (matchCount == 3) {
            return Match.THREE_MATCH.name();
        }

        return Match.NO_MATCH.name();
    }

    int checkPrizeNumberMatch(Lotto ticket, Lotto prizeNumber) {
        List<Integer> matches = ticket.getNumbers().stream()
                .filter(num -> prizeNumber.getNumbers().contains(num))
                .toList();

        return matches.size();
    }

    boolean checkBonusNumberMatch(int bonusNumber, Lotto prizeNumber) {
        for (int num : prizeNumber.getNumbers()) {
            if (num == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public double getReturnOfInvestment(Map<String, Integer> matchResults) {
        long sixMatchPrize = matchResults.getOrDefault(Match.SIX_MATCH.name(), 0) * Match.SIX_MATCH.getPrizeAmount();
        long fiveAndBonusMatchPrize = matchResults.getOrDefault(Match.FIVE_AND_BONUS_MATCH.name(), 0) * Match.FIVE_AND_BONUS_MATCH.getPrizeAmount();
        long fiveMatchPrize = matchResults.getOrDefault(Match.FIVE_MATCH_ONLY.name(), 0) * Match.FIVE_MATCH_ONLY.getPrizeAmount();
        long fourMatchPrize = matchResults.getOrDefault(Match.FOUR_MATCH.name(), 0) * Match.FOUR_MATCH.getPrizeAmount();
        long threeMatchPrize = matchResults.getOrDefault(Match.THREE_MATCH.name(), 0) * Match.THREE_MATCH.getPrizeAmount();

        long totalSum = sixMatchPrize + fiveAndBonusMatchPrize + fiveMatchPrize + fourMatchPrize + threeMatchPrize;

        return (totalSum / (double) money) * TO_MAKE_PERCENTAGE;
    }
}
