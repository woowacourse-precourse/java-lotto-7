package view;

import domain.WinningPrice;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(Map<WinningPrice, Integer> lottoResult) {
        for (WinningPrice winningPrice : lottoResult.keySet()) {
            System.out.println(winningPrice.getDescription() +" " + lottoResult.get(winningPrice));
        }
    }

}
