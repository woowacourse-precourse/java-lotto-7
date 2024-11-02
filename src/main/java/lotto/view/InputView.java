package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readInput(String requestMessage){
        System.out.println(requestMessage);
        return Console.readLine();
    }

}
