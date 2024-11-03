package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryProcess {
    private final List<Integer> numbers;
    private final int bonusBallNumber;
    private final List<List<Integer>> tickets;

    private static final int RANKINGS_NUMBER = 5;
    private final List<Integer> rankingCount = new ArrayList<>(Collections.nCopies(RANKINGS_NUMBER, 0));


    public LotteryProcess(List<Integer> numbers, int bonusBallNumber, List<List<Integer>> tickets) {
        this.numbers = numbers;
        this.bonusBallNumber = bonusBallNumber;
        this.tickets = tickets;
    }

    public List<Integer> countMatchNumbers() {
        for (List<Integer> ticket : tickets) {
            int matchNumberCount = searchMatchNumbers(ticket);
            boolean bonusBallMatch = ticket.contains(bonusBallNumber);

            LottoRank rank = LottoRank.calculateRank(matchNumberCount, bonusBallMatch);

            if (rank != null) {
                int rankIndex = rank.ordinal();  // Enum 순서에 따른 인덱스 활용
                rankingCount.set(rankIndex, rankingCount.get(rankIndex) + 1);
            }
        }

        return rankingCount;
    }

    private int searchMatchNumbers(List<Integer> ticket) {
        int matchCount = 0;

        for (int lottoNumber : numbers) {

            if (ticket.contains(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }
}