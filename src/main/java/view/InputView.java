package view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static Integer inputCost() {
        String cost = Console.readLine();
        return Integer.parseInt(cost);
    }
}
