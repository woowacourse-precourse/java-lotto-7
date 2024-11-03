package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import jdk.jshell.execution.Util;
import lotto.utils.Utils;
import lotto.validator.Validator;

import java.util.List;

public class InputView {

    public static int inputLottoAmount(){

        while (true) {
            try {

                int lottoAmount = Integer.parseInt(Console.readLine());
                Validator.validateLottoAmountIsPositiveAndDivisibleByThousand(lottoAmount);

                return lottoAmount;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static List<Integer> inputLottoWinningNumbers(){

        while (true) {
            try {

                List<Integer> lottoWinningNumbers = Validator.validateWinningNumberSeparatorAndNotNumber(Console.readLine());
                Validator.validateAllWinningNumbers(lottoWinningNumbers);

                return lottoWinningNumbers;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Integer inputLottoBonusNumber(){

        while (true) {
            try {

                return Validator.validateSingleBonusNumber(Console.readLine());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
