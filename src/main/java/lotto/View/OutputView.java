package lotto.View;

import java.util.Map;
import lotto.Model.Ranking;

public class OutputView{
    private final Map<Ranking,Integer> rankingCount;

    public OutputView(Map<Ranking,Integer> rankingCount) {
        this.rankingCount = rankingCount;
    }

    public void printSuccessResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printresult(){
        rankingCount.forEach((rank,count)->{
            if(rank==Ranking.MISS){
                return;
            }
            System.out.println(rank.getMessage() + count + "개");
        });

    }

    public static void PrintRevenueRate(double revenue){
        System.out.println("총 수익률은 "+String.format("%.1f",revenue*100)+"입니다");
    }




}
