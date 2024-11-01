package lotto.View;

import java.util.Map;
import lotto.Model.Ranking;

public class OutputView{

    public void printSuccessResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printResult(Map<Ranking,Integer> rankingCount){
        rankingCount.forEach((rank,count)->{
            if(rank==Ranking.MISS){
                return;
            }
            System.out.println(rank.getMessage() + count + "개");
        });

    }

    public static void printRevenueRate(double revenue){
        System.out.println("총 수익률은 "+String.format("%.1f",revenue*100)+"%입니다.");
    }




}
