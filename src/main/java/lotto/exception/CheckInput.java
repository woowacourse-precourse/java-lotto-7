package lotto.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.enums.ErrorType;

public class CheckInput {

    public static boolean checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            System.out.println(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage());
            return false;
        }

        if (inputMoney % 1000 != 0) {
            System.out.println(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage());
            return false;
        }

        return true;
    }

    public static Lotto checkLottoNumbers(String inputLottoNumbers) {
        String[] splitInputLottoNumbers = inputLottoNumbers.split(",");

        List<Integer> tmpLottoNumber = new ArrayList<>();
        for (String splitInputLottoNumber : splitInputLottoNumbers) {
            try {
                int tmpNumber = Integer.parseInt(splitInputLottoNumber.trim());

                if (tmpNumber < 1 || tmpNumber > 45) {
                    throw new IllegalArgumentException();
                }

                tmpLottoNumber.add(tmpNumber);
            } catch (NumberFormatException e) {
                System.out.println(ErrorType.INVALID_LOTTO_NUMBER_FORMAT.getErrorMessage());
                return null;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
                return null;
            } catch (Exception e) {
                System.out.println(ErrorType.UNEXPECTED_ERROR.getErrorMessage());
                return null;
            }
        }

        Collections.sort(tmpLottoNumber);
        Lotto tmpLotto = new Lotto(tmpLottoNumber);

        return tmpLotto;
    }

    public static boolean checkBonusNumber(int bonusNum, Lotto winningLottoNumbers) {
        if (bonusNum < 1 || bonusNum > 45) {
            System.out.println(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
            return false;
        }

        if (winningLottoNumbers.checkDuplicateWithBonusNumber(bonusNum)) {
            System.out.println(ErrorType.INVALID_LOTTO_BONUS_NUMBER_DUPLICATE.getErrorMessage());
            return false;
        }

        return true;
    }

}