package lotto.View;

import java.util.Map;
import lotto.Model.Ranking;

public class OutputView{


    public static void printSuccessResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    //각 Ranking 별 일치개수를 반환 로직
    public static void printResult(Map<Ranking,Integer> rankingCount){
        rankingCount.forEach((rank,count)->{
            if(rank==Ranking.MISS){
                return;
            }
            System.out.println(rank.getMessage() + count + "개");
        });

    }
    //수익률 반환 로직
    public static void printRevenueRate(double revenue){
        System.out.println("총 수익률은 "+String.format("%.1f",revenue*100)+"%입니다.");
    }




}
