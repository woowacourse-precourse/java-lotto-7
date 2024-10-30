package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.input.UserBonusNumberInput;
import lotto.service.PrintTicketCount;

public class LotteryProcess {
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final List<List<Integer>> userTicketNumbers;
    private int matchNumberCount;

    private final int RANKING_NUMBER = 5;
    private final List<Integer> rankingCount = new ArrayList<>(Collections.nCopies(RANKING_NUMBER, 0));


    public LotteryProcess(Lotto lotto, UserBonusNumberInput userBonusNumberInput,
                          PrintTicketCount printTicketCount) {
        this.numbers = lotto.getNumbers();
        this.bonusNumber = userBonusNumberInput.getBonusNumber();
        this.userTicketNumbers = printTicketCount.getTicketNumbers();
    }

    public void countMatchNumbers() {
        for (List<Integer> ticket : userTicketNumbers) {
            matchNumberCount = 0;
            searchMatchNumbers(ticket);

            boolean bonusMatch = ticket.contains(bonusNumber);
            LottoRank rank = LottoRank.calculateRank(matchNumberCount, bonusMatch);

            if (rank != null) {
                int rankIndex = rank.ordinal();  // Enum 순서에 따른 인덱스 활용
                rankingCount.set(rankIndex, rankingCount.get(rankIndex) + 1);
            }
        }
    }

    public List<Integer> getRankingCount() {
        return rankingCount;
    }

    private void searchMatchNumbers(List<Integer> ticket) {
        for (int lottoNumber : numbers) {
            if (ticket.contains(lottoNumber)) {
                matchNumberCount++;
            }
        }
    }
}