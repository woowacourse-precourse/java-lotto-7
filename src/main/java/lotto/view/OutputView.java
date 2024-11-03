package lotto.view;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;

import static lotto.console.ConsoleManager.*;

public class OutputView {
    public void displayCount(int count){
        println(count + "개를 구매했습니다.");
    }
    public void displayLotto(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Number> numbers = lotto.getNumbers();
            String line = getDecoratedLine(numbers);
            println(line);
        }
        println();
    }

    private static String getDecoratedLine(List<Number> numbers) {
        StringBuilder line = new StringBuilder("[");
        for (Number number : numbers) {
            line.append(number.get()).append(", ");
        }
        line = new StringBuilder(line.substring(0, line.length() - 2) + "]");
        return line.toString();
    }
}
