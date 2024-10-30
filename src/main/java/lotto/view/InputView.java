package lotto.view;

import lotto.utils.Utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int inputBuyAmount(){
        return Utils.stringToInteger(readLine());
    }
}
