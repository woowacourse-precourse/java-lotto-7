package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import jdk.jshell.execution.Util;
import lotto.utils.Utils;

import java.util.List;

public class InputView {

    public static Integer inputLottoAmount(){

        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputLottoWinningNumbers(){

        return Utils.splitWinningNumber(Console.readLine());
    }

    public static Integer inputLottoBonusNumber(){

        return Integer.parseInt(Console.readLine());
    }

}
