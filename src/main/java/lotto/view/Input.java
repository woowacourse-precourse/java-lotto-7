package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Parser;

import java.util.List;

public class Input {
    public String text() {
        return Console.readLine();
    }

    public int number() {
        return Parser.parseInt(Console.readLine());
    }

    public List<Integer> numbers() {
        return Parser.parseNumbers(Console.readLine());
    }
}
