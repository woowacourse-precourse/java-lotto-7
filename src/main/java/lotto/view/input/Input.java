package lotto.view.input;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String purchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();

    }

}
