package lotto.view;

import java.util.List;

public class OutputView {
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
}
