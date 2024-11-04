package lotto.view;

import java.util.List;

public class OutputView {
    private static final int THREE_CORRECT = 3;
    private static final int FOUR_CORRECT = 4;
    private static final int FIVE_CORRECT = 5;
    private static final int FIVE_AND_BONUS_CORRECT = 7;
    private static final int SIX_CORRECT = 6;

    public static void printLottoList(List<Integer> randomLottoNumber){
        System.out.println(randomLottoNumber);
    }
    public static void printCount(int ticketCount){
        System.out.println(ticketCount+"개를 구매했습니다.");
    }
    public static void printTotal(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printCorrect(int[] count){
        System.out.println("3개 일치 (5,000원) - "+count[THREE_CORRECT]+"개");
        System.out.println("4개 일치 (50,000원) - "+count[FOUR_CORRECT]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+count[FIVE_CORRECT]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+count[FIVE_AND_BONUS_CORRECT]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+count[SIX_CORRECT]+"개");
    }
    public static void printRate(double EarnRate){
        System.out.println("총 수익률은 "+String.format("%.1f", EarnRate) + "%입니다.");
    }
}
