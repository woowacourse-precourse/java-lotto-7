package lotto.view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public String input(){
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
