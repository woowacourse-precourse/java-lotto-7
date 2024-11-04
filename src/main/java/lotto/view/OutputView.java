package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.constant.WinningRank;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void printBlank() {
        System.out.println();
    }

    public void printWinningStatisticHead() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningStatisticBody(Entry<WinningRank, Integer> entry) {
        System.out.println(entry.getKey().getMessage() + entry.getValue() + "개");
    }
}
