package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {
    public String getPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }
    public int getNumberOfPurchase(int purchaseNumber){
        int numberOfPurchases = purchaseNumber / 1000;
        System.out.println("\n" + numberOfPurchases + "개를 구매했습니다.");

        return numberOfPurchases;
    }
    public void printLottoNumbers(List<Lotto> lottoNumbers){
        // 구입한 로또 번호 출력
        ListIterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getList());
        }
    }
    public String getWinningNumbers(){
        // 당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return readLine();
    }
    public int getBonusNumber(){
        // 보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
    public void printMatchedResult(HashMap<Integer, Integer> matchedResult, int countHasBonusNumber){
        System.out.println("\n당첨 통계\n---");
        System.out.println(PrizeInfo.THREE.getDescription() + " - " + matchedResult.get(3) + "개");
        System.out.println(PrizeInfo.FOUR.getDescription() + " - " + matchedResult.get(4) + "개");
        System.out.println(PrizeInfo.FIVE.getDescription() + " - " + matchedResult.get(5) + "개");
        System.out.println(PrizeInfo.FIVE_BONUS.getDescription() + " - " + countHasBonusNumber + "개");
        System.out.println(PrizeInfo.SIX.getDescription() + " - " + matchedResult.get(6) + "개");
    }
    public void finalResult(double statistic){
        System.out.println("총 수익률은 " + Math.round(statistic * 10) / 10.0 + "%입니다.");
    }
}
