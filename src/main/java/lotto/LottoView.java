package lotto;

import java.util.Collections;
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
    public double printMatchedResult(List<Integer> countMatched, int countHasBonusNumber){
        int count;
        double statistics = 0;
        System.out.println("\n당첨 통계\n---");

        count = Collections.frequency(countMatched, 3);
        statistics += count * 5000;
        System.out.println("3개 일치 (5,000원) - " + count + "개");

        count = Collections.frequency(countMatched, 4);
        statistics += count * 50000;
        System.out.println("4개 일치 (50,000원) - " + count + "개");

        count = Collections.frequency(countMatched, 5);
        statistics += count * 1500000;
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");

        statistics += countHasBonusNumber * 30000000;
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countHasBonusNumber + "개");

        count = Collections.frequency(countMatched, 6);
        statistics += count * 2000000000;
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");

        return statistics;
    }
    public void finalResult(double statistics){
        System.out.println("총 수익률은 " + statistics + "%입니다.");
    }
}
