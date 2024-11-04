package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class InputValidator implements Validator{

    private static final String WHITE_SPACE_REGEX = "\\s";
    private static final String EMPTY_STRING = "";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;
    private static final String NEED_NUMBER_IN_RANGE = "구매 금액은 1000이상 100000이하여야 합니다.";


    @Override
    public void checkIfEmpty(String input){
        if (input.isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
        if (input.replaceAll(WHITE_SPACE_REGEX, EMPTY_STRING).isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
    }

    @Override
    public void checkIfEmpty(List<Integer> input){
        if (input.isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
    }


    @Override
    public void checkIfDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new InputErrorException(ErrorType.NEED_NUMBER);
            }
        }
    }

    @Override
    public void validateOnlyDigit(List<String> lottoNumbers){
        lottoNumbers.forEach(lottoNumber -> {
            checkIfEmpty(lottoNumber);
            checkIfDigit(lottoNumber);
        });
    }


    @Override
    public void validateOnlyDigit(String input){
        checkIfEmpty(input);
        checkIfDigit(input);
    }

    @Override
    public void checkValidRange(Lotto lotto){
        lotto.getLottoNumbers().forEach(lottoNumber -> {
            if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
                throw new InputErrorException(ErrorType.NEED_NUMBER_IN_RANGE);
            }
        });

    }


    @Override
    public void checkValidRange(Integer bonusNumber){
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new InputErrorException(ErrorType.NEED_NUMBER_IN_RANGE);
        }
    }

    @Override
    public void checkValidRange(int lottoCount){
        if (lottoCount < MIN_PURCHASE_AMOUNT || lottoCount > MAX_PURCHASE_AMOUNT) {
            throw new InputErrorException(NEED_NUMBER_IN_RANGE);
        }
    }


    @Override
    public void checkDuplicate(List<Integer> numbers){
        Set<Integer> distinctLottoNumbers = new HashSet<>();

        for (Integer lottoNumber : numbers) {
            if (!distinctLottoNumbers.add(lottoNumber)) {
                throw new InputErrorException(ErrorType.NEED_DISTINCT_NUMBER);
            }
        }
    }

    @Override
    public void checkDuplicate(Integer bonusNumber, Lotto lotto) {
        lotto.getLottoNumbers().forEach(lottoNumber -> {
            if (lottoNumber.equals(bonusNumber)) {
                throw new InputErrorException(ErrorType.NEED_DISTINCT_NUMBER);
            }
        });
    }
}
