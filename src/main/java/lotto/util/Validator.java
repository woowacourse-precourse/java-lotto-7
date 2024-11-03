package lotto.util;

import java.util.List;
import lotto.model.Lotto;

public interface Validator {

    void checkIfEmpty(String input);
    void checkIfEmpty(List<Integer> input);

    void checkIfDigit(String input);

    void validateOnlyDigit(List<String> input);
    void validateOnlyDigit(String input);

    void checkValidRange(Lotto lotto);
    void checkValidRange(Integer bonusNumber);
    void checkValidRange(int lottoCount);

    void checkDuplicate(List<Integer> numbers);
    void checkDuplicate(Integer bonusNumber, Lotto lotto);
}


