package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private final WinningLotto winningLotto;

    public LottoGame(int purchaseAmount, List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        purchaseLotto(purchaseAmount);
    }

    public void purchaseLotto(int price){
        int NumsLotto = price / 1000;
        for(int i=0; i<NumsLotto; i++){
            lottos.add(LottoGenerator.generate());
        }
    }

    public void printLottos(){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult() {
        int totalPrize = 0;
        int[] countByRank = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            countByRank[rank.ordinal()]++;
            totalPrize += rank.getPrize();
        }
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + countByRank[Rank.FIFTH.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " + countByRank[Rank.FOURTH.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countByRank[Rank.THIRD.ordinal()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countByRank[Rank.SECOND.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countByRank[Rank.FIRST.ordinal()] + "개");

        double rateOfReturn = ((double) totalPrize / (lottos.size() * 1000)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

}
