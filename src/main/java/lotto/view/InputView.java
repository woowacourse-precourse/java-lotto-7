package lotto.view;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();
        return amount;
    }

}
