package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    Map<Rank,Integer> savePot = new HashMap<>();
    double totalRevenue = 0;
    int money=0;

    public void checkSingleLotto(List<List<Integer>> myLottos, List<Integer> winningNumbers, int bonusNum) {
        initializeRankMap();

        for (List<Integer> getLotto : myLottos) {
            int count = countMatches(getLotto, winningNumbers);
            updateRank(count, winningNumbers, bonusNum);
        }
    }

    private void initializeRankMap() {
        for (Rank rank : Rank.values()) {
            savePot.put(rank, 0);
        }
    }

    private int countMatches(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int singleValue : lotto) {
            if (winningNumbers.contains(singleValue)) {
                count++;
            }
        }
        return count;
    }

    private void updateRank(int count, List<Integer> winningNumbers, int bonusNum) {
        if (count == 6) savePot.put(Rank.checkRank(count, false), savePot.get(Rank.FIRST) + 1);
        if (count == 5) {
            if (winningNumbers.contains(bonusNum)) {
                savePot.put(Rank.SECOND, savePot.get(Rank.SECOND) + 1);
            }
            if (!winningNumbers.contains(bonusNum)) {
                savePot.put(Rank.THIRD, savePot.get(Rank.THIRD) + 1);
            }
        }
        if (count == 4) savePot.put(Rank.checkRank(count, false), savePot.get(Rank.FOURTH) + 1);
        if (count == 3) savePot.put(Rank.checkRank(count, false), savePot.get(Rank.FIFTH) + 1);
        if (count < 3) savePot.put(Rank.checkRank(0, false), savePot.get(Rank.NONE) + 1);
    }

    public void caculate(){
        for (Rank rank : Rank.values()) {
            int count = savePot.get(rank);
            totalRevenue += (count * rank.getWinningAmount());
        }
    }

    public void setPurchaseAmount(int money){
        this.money = money;
    }

    public void printResult(){
        System.out.println("3개 일치 (5,000원) - "+savePot.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - "+savePot.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+savePot.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+savePot.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+savePot.get(Rank.FIRST)+"개");
        System.out.println("총 수익률은 "+(totalRevenue/money)*100+"%입니다.");
    }

}
