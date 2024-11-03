package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorCode;

import java.util.NoSuchElementException;

public class Input {
    public static String inputPrice() throws NoSuchElementException {
        View.printInputPrice();
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new NoSuchElementException(ErrorCode.NO_INPUT.getErrorMessage());
        }
    }

    public static String inputWinningNumber() throws NoSuchElementException {
        View.printInputWinningNumber();
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new NoSuchElementException(ErrorCode.NO_INPUT.getErrorMessage());
        }
    }

    public static String inputBonusNumber() throws NoSuchElementException {
        View.printInputBonusNumber();
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new NoSuchElementException(ErrorCode.NO_INPUT.getErrorMessage());
        }
    }
}
