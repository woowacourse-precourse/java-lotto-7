package view;

import constants.OutputFormats;

import java.util.List;

public class OutputView {

    public static void outputMyLotto(List<List<Integer>> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        myLotto.forEach(System.out::println);
    }

    public static void outputPrizeResult(List<Integer> result) {
        List<String> outputStrings = OutputFormats.getAllResults(result);
        outputStrings.forEach(System.out::println);
    }

    public static void outputWinningRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

}
