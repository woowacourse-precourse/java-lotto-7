package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.console.ConsoleManager.*;

public class OutputView {
    public void displayCount(int count){
        println(count + "개를 구매했습니다.");
    }
    public void displayLotto(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            String line = getDecoratedLine(numbers);
            println(line);
        }
        println();
    }

    private static String getDecoratedLine(List<Integer> numbers) {
        StringBuilder line = new StringBuilder("[");
        for (Integer number : numbers) {
            line.append(number).append(", ");
        }
        line = new StringBuilder(line.substring(0, line.length() - 2) + "]");
        return line.toString();
    }
}
