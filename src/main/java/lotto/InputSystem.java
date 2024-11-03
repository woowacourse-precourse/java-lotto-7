package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputSystem {
    public static int inputLottoPurchaseAmount(){
        return Integer.parseInt(Console.readLine());
    }
    public static String[] inputLottoNumber(){
        return Console.readLine().split(",");
    }

    public static int inputBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
