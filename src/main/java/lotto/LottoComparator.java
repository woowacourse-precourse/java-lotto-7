package lotto;

import java.util.List;

import static lotto.InputValidator.LOTTO_PRICE_UNIT;

public class LottoComparator {

    private final List<Lotto> customerTickets;
    private final Lotto winningTicket;
    private final int bonusNumber;
    private int totalPrize;
    private int[] rankCount;

    public LottoComparator(List<Lotto> customerTickets, Lotto winningTicket, int bonusNumber) {
        this.customerTickets = customerTickets;
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
        this.totalPrize = 0;
        this.rankCount = new int[LottoRank.values().length];
    }

    public void printResult(){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : LottoRank.values()) {
            if(lottoRank != LottoRank.NONE_MATCH){
                System.out.println(lottoRank.getMessage() + " - " + rankCount[lottoRank.ordinal()] + "개");
            }
        }
        double profitRate = ((double) totalPrize / (customerTickets.size() * LOTTO_PRICE_UNIT)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public void calculateResult(){
        for (Lotto customerTicket : customerTickets) {
            int matchCount = getMatchCount(customerTicket.getNumbers(), winningTicket.getNumbers());
            boolean bonusMatch = customerTicket.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(matchCount, bonusMatch);

            validateNoneMatch(rank);
        }
    }

    public int getMatchCount(List<Integer> customerNumbers, List<Integer> winningNumbers){
        int count = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            if(customerNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private void validateNoneMatch(LottoRank rank) {
        if(rank != LottoRank.NONE_MATCH){
            rankCount[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }
    }
}
