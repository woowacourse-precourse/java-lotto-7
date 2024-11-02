package lotto.system.output;

import java.util.List;
import lotto.system.SystemIO;

public class OutputView {

    public void showQuantityMessage(int quantity) {
        SystemIO.showMessageToConsole(quantity + "개를 구매했습니다.");
    }

    public void showLotto(List<Integer> lotto) {
        System.out.println(lotto);
        SystemIO.showMessageToConsole(lotto);
    }

    public void showIncomeRate(double rate) {
        SystemIO.showMessageToConsole("총 수익률은 " + rate + "%입니다.");
    }

    public static void showResultOfBoard(String condition, int count) {
        SystemIO.showMessageToConsole(condition + " - " + count + "개");
    }

    public static void showErrorMessage(String error) {
        SystemIO.showMessageToConsole("[ERROR]" + error);
    }
}
