package lotto.view;

import java.util.List;
import java.util.HashMap;

import lotto.model.Lotto;
import lotto.util.Rank;

public class OutputView {
    public void requirePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void requireWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requireBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottos(int countLotto, List<Lotto> lottos) {
        System.out.println();
        System.out.println(countLotto + "개를 구매했습니다.");
        
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto.getLotto());
        }
    }
    
    private void printLottoNumbers(List<Integer> numbers) {
        StringBuilder lottoNumbers = new StringBuilder("[");
        
        for (int i = 0; i < numbers.size(); i++) {
            lottoNumbers.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                lottoNumbers.append(", ");
            }
        }
        lottoNumbers.append("]");
        System.out.println(lottoNumbers);
    }

    public void printWinningResult(HashMap<Integer,Integer> winningRecord) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+ winningRecord.get(Rank.FIFTH.getRankOrder()) +"개");
        System.out.println("4개 일치 (50,000원) - "+ winningRecord.get(Rank.FOURTH.getRankOrder()) +"개");
        System.out.println("5개 일치 (1,500,000원) - "+ winningRecord.get(Rank.THIRD.getRankOrder()) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ winningRecord.get(Rank.SECOND.getRankOrder()) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ winningRecord.get(Rank.FIRST.getRankOrder()) +"개");
    }

    public void printProfitMargin(double profitMargin) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n",profitMargin);
    }
}
