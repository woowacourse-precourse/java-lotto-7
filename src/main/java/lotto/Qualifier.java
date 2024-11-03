package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Qualifier {


    private static final String CHOSEN_STATISTIC = "당첨 통계\n---";
    private static final String FIFTH_RANK = "3개 일치 (5,000원) - ";
    private static final String FOUR_RANK = "4개 일치 (50,000원) - ";
    private static final String THIRD_RANK = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_RANK = "6개 일치 (2,000,000,000원) - ";
    private static final Integer FIFTH_AWARD = 5000;
    private static final Integer FOUR_AWARD = 50000;
    private static final Integer THIRD_AWARD = 1500000;
    private static final Integer SECOND_AWARD = 30000000;
    private static final Integer FIRST_AWARD = 2000000000;
    private static final String UtilCnt = "개";
    private static final String NEWLINE = "\n";
    private static final String TOTAL_PERCENTS = "총 수익률은 ";
    private static final String PERCENT_IS = "%입니다.";
    private final List<Integer> numbers;
    private final Integer bonusNum;

    public Qualifier(List<Integer> numbers, Integer bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> analysis(List<List<Integer>> purchaseLotto) {

        //nothing, FIRST, SECOND, THIRD, FOUR, FIFTH
        List<Integer> history = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (List<Integer> lottoNumbers : purchaseLotto) {
            chkNumbers(lottoNumbers, history);
        }
        return history;
    }

    public void chkNumbers(List<Integer> lottoNumbers, List<Integer> history) {
        int chkTrueSize = 0;

        boolean bonusChk = false;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(lottoNumbers.get(i))) chkTrueSize++;
            if (Objects.equals(bonusNum, lottoNumbers.get(i))) bonusChk = true;
        }
        updateHistory(chkTrueSize, bonusChk, history);
    }

    public void updateHistory(int chkTrueSize, boolean bonusChk, List<Integer> history){
        if (chkTrueSize == 3) {
            history.set(Rank.FIFTH.getIdx(), history.get(Rank.FIFTH.getIdx()) + 1);
        } else if (chkTrueSize == 4) {
            history.add(Rank.FOUR.getIdx(), history.get(Rank.FOUR.getIdx()) + 1);
        } else if (chkTrueSize == 5 && bonusChk) {
            //보너스 번호 일치하는지 체크
            history.set(Rank.SECOND.getIdx(), history.get(Rank.SECOND.getIdx()) + 1);
        } else if (chkTrueSize == 5) {
            history.set(Rank.THIRD.getIdx(), history.get(Rank.THIRD.getIdx()) + 1);
        } else if (chkTrueSize == 6) {
            history.set(Rank.FIRST.getIdx(), history.get(Rank.FIRST.getIdx()) + 1);
        }
    }

    public void printResult(int originalMoney, List<Integer> history) {

        System.out.println(CHOSEN_STATISTIC);
        System.out.print(FIFTH_RANK + history.get(Rank.FIFTH.getIdx()) + UtilCnt + NEWLINE);
        System.out.print(FOUR_RANK + history.get(Rank.FOUR.getIdx()) + UtilCnt + NEWLINE);
        System.out.print(THIRD_RANK + history.get(Rank.THIRD.getIdx()) + UtilCnt + NEWLINE);
        System.out.print(SECOND_RANK + history.get(Rank.SECOND.getIdx()) + UtilCnt + NEWLINE);
        System.out.print(FIRST_RANK + history.get(Rank.FIRST.getIdx()) + UtilCnt + NEWLINE);


        System.out.println(TOTAL_PERCENTS + calcProfit(originalMoney, history) + PERCENT_IS);
    }

    public String calcProfit(int originalMoney, List<Integer> history) {
        double totalSum = 0;
        totalSum += FIFTH_AWARD * history.get(0);
        totalSum += FOUR_AWARD * history.get(1);
        totalSum += THIRD_AWARD * history.get(2);
        totalSum += SECOND_AWARD * history.get(3);
        totalSum += FIRST_AWARD * history.get(4);

        double profitRate = (totalSum / originalMoney) * 100;

        return String.format("%.1f", profitRate);
    }

}
