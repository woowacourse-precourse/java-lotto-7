package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class Output {

    public void printCount(int count){
        System.out.printf("%d개를 구매했습니다.",count);
    }
    public void printNumbers(List<Number> numbers){
        System.out.println(numbers);
    }
    public void printResult(HashMap<Rank,Integer> result){
        System.out.println("\n담첨 통계");
        System.out.println("---");
        for(Rank rank : Rank.values()){
            printRankResult(rank,result);
        }
    }
    public void printRankResult(Rank rank, HashMap<Rank,Integer> result){
        if(rank.equals(Rank.LOSE)){
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                rank.getMatchLotto(), rank.getPrize(), result.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getMatchLotto(), rank.getPrize(), result.get(rank));
    }
    public void printEarningRate(double rate){
        System.out.printf("총 수익률은 %.1f입니다",rate);
    }

}
