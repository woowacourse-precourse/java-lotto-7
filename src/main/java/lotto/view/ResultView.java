package lotto.view;

import java.util.HashMap;
import lotto.message.ResultMessage;

public class ResultView {

    public static void displayLottoResultTitle() {
        System.out.println("\n" + ResultMessage.DISPLAY_LOTTO_RESULT.getMessage());
        System.out.println(ResultMessage.DISPLAY_LOTTO_RESULT_BOUNDARY.getMessage());
    }

    public static void displayLottoResultState(HashMap<Integer, Integer> resultMap) {
        System.out.println(String.format("%d개 일치 (%,d원) - %d개", 3, 5000, resultMap.getOrDefault(3, 0)));
        System.out.println(String.format("%d개 일치 (%,d원) - %d개", 4, 50000, resultMap.getOrDefault(4, 0)));
        System.out.println(String.format("%d개 일치 (%,d원) - %d개", 5, 1500000, resultMap.getOrDefault(5, 0)));
        System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", 5, 30000000, resultMap.getOrDefault(50, 0)));
        System.out.println(String.format("%d개 일치 (%,d원) - %d개", 6, 2000000000, resultMap.getOrDefault(6, 0)));
    }
}
