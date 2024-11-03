package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import jdk.jshell.execution.Util;
import lotto.utils.Utils;
import lotto.validator.Validator;

import java.util.List;

public class InputView {

    public static int inputLottoAmount(){

        int lottoAmount = Integer.parseInt(Console.readLine());

        try {
            Validator.validateLottoAmountIsPositiveAndDivisibleByThousand(lottoAmount);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return lottoAmount;

    }

    public static List<Integer> inputLottoWinningNumbers(){

        List<Integer> lottoWinningNumbers = Validator.validateWinningNumberSeparatorAndNotNumber(Console.readLine());

        try {
            Validator.validateAllWinningNumbers(lottoWinningNumbers);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return lottoWinningNumbers;
    }

    public static Integer inputLottoBonusNumber(){

        return Validator.validateSingleBonusNumber(Console.readLine());
    }

}
