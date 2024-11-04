package lotto;

import InputOutput.InputView;
import Rank.Rank;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static List<List<Integer>> createLottoTickets(int ticket) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticket; i++) {
            List<Integer> randomNumbers = InputView.random();
            Collections.sort(randomNumbers);
            lottoTickets.add(randomNumbers);
        }
        return lottoTickets;
    }

    public static Map<Rank, Integer> calculateWinningResults(List<List<Integer>> lottoTickets, List<Integer> winNumber, int bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (List<Integer> lottoTicket : lottoTickets) {
            int matchCount = countMatches(lottoTicket, winNumber);
            boolean bonusMatch = lottoTicket.contains(bonusNumber);
            Rank rank = Rank.findRank(matchCount, bonusMatch);

            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    private static int countMatches(List<Integer> lottoTicket, List<Integer> winNumber) {
        int matchCount = 0;

        for (Integer number : lottoTicket) {
            if (winNumber.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }
}