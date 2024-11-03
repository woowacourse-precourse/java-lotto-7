package lotto.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.enums.ErrorType;

public class CheckInput {

    public static void checkInputMoney(int inputMoney) {
        if (inputMoney < 1000) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage());
        }

        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage());
        }
    }

    public static Lotto checkLottoNumbers(String inputLottoNumbers){
        String[] splitInputLottoNumbers = inputLottoNumbers.split(",");

        List<Integer> tmpLottoNumber = new ArrayList<>();
        for (String splitInputLottoNumber : splitInputLottoNumbers) {
            try{
                int tmpNumber = Integer.parseInt(splitInputLottoNumber.trim());

                if(tmpNumber < 1 || tmpNumber > 45){
                    throw new IllegalArgumentException();
                }

                tmpLottoNumber.add(tmpNumber);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER_FORMAT.getErrorMessage());
            } catch (IllegalArgumentException e){
                throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
            } catch (Exception e){
                throw new IllegalArgumentException(ErrorType.UNEXPECTED_ERROR.getErrorMessage());
            }
        }

        Collections.sort(tmpLottoNumber);
        Lotto tmpLotto = new Lotto(tmpLottoNumber);

        return tmpLotto;
    }

    public static void checkBonusNumber(int bonusNum, Lotto winningLottoNumbers){
        if(bonusNum < 1 || bonusNum > 45){
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }

        if(winningLottoNumbers.checkDuplicateWithBonusNumber(bonusNum)){
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_BONUS_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

}
