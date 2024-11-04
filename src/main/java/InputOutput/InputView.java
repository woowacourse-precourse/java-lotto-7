package InputOutput;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class InputView {
    public static String 입력() {
        return Console.readLine();
    }
    public static List<Integer> 랜덤(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
