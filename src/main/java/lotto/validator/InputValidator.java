package lotto.validator;

import lotto.contants.message.ErrorMessage;
import lotto.contants.value.LottoValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public boolean payment(String payment) {
        if (!empty(payment)) {
            return false;
        }
        if (!convertToInteger(payment)) {
            return false;
        }
        if (!paymentByUnit(payment)) {
            return false;
        }
        return true;
    }

    public boolean prizeNumber(String[] splitPrizeNumbers) {
        if (!lottoSize(splitPrizeNumbers.length)) {
            return false;
        }
        Set<String> notDuplication = new HashSet<>();
        for (String str : splitPrizeNumbers) {
            if(!separateChar(notDuplication,str)){
                return false;
            }
        }
        return true;
    }

    public boolean bonusNumber(List<Integer> prizeNumbers, String str) {
        if (!common(str)) {
            return false;
        }
        if (!sameNumber(prizeNumbers, Integer.parseInt(str))) {
            return false;
        }
        return true;
    }

    public boolean common(String str) {
        if (!empty(str)) {
            return false;
        }
        if (!convertToInteger(str)) {
            return false;
        }
        if (!lottoRange(str)) {
            return false;
        }
        return true;
    }

    public boolean separateChar(Set<String> notDuplication,String str) {
        if (!common(str)) {
            return false;
        }
        if(!sameNumberInPrize(notDuplication,str)){
            return false;
        }
        return true;
    }

    public boolean paymentByUnit(String payment) {
        try {
            if (Integer.parseInt(payment) % LottoValue.PRICE_UNIT.getValue() != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.PURCHASE_PRICE.getMessage());
            return false;
        }

        return true;
    }

    public boolean convertToInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.TYPE.getMessage());
            return false;
        }
        return true;
    }

    public boolean lottoRange(String str) {
        try {
            if (Integer.parseInt(str) > 45) {
                throw new IllegalArgumentException();
            }
            if (Integer.parseInt(str) < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
            return false;
        }
        return true;
    }

    public boolean empty(String str) {
        try {
            if (str.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.SPILT_EMPTY.getMessage());
            return false;
        }
        return true;
    }

    public boolean lottoSize(int size) {
        try {
            if (size != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.LOTTO_SIZE.getMessage());
            return false;
        }
        return true;
    }

    public boolean sameNumber(List<Integer> prizeNumbers, int bonusNumber) {
        try {
            if (prizeNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.LOTTO_BONUS.getMessage());
            return false;
        }
        return true;
    }

    public boolean sameNumberInPrize( Set<String> notDuplication, String str) {
        try {
            if(!notDuplication.add(str)){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.LOTTO_DUPLICATION.getMessage());
            return false;
        }
        return true;
    }
}
