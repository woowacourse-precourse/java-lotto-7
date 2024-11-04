package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoCount(String lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void printMatchStatistics(List<String> matchStatistics) {
        System.out.println("당첨 통계" + System.lineSeparator() + "---");
        matchStatistics.forEach(System.out::println);
    }

    public void printYield(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
