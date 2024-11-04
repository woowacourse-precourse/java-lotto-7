package lotto.view;

import lotto.controller.OutputController;

import java.util.List;

public class OutputView {
    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println("\n" + lottoNumbers.size() + "개를 구매했습니다.");
        for (List<Integer> innerList : lottoNumbers) {
            String formattedNumbers = OutputController.formatLottoNumbers(innerList);
            System.out.println(formattedNumbers);
        }
    }

    public static void printWinningComment() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }
}
