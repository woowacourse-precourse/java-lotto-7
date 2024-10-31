package lotto;

import java.util.List;

public class Validator {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_PRICE = 1000;

    private static final String ERROR = "[ERROR] ";
    private static final String NUMBER_COUNT_ERROR_MESSAGE = "당첨 번호는 6개의 숫자로 이루어져야 합니다.";
    private static final String ONLY_NUMBER_ALLOWED_MESSAGE = "숫자만 입력되어야 합니다.";
    private static final String LOTTO_PRICE_MUST_BE_MULTIPLE_OF_1000_MESSAGE = "로또 구입 금액은 1,000원 단위로 입력받아야 합니다.";
    private static final String LOTTO_RANGE_ERROR_MESSAGE = "당첨 번호는 1 이상 45 이하이어야 합니다.";
    private static final String DUPLICATE_ELEMENT_ERROR_MESSAGE = "당첨 번호 및 보너스 번호는 중복될 수 없습니다.";

    public void purchaseAmountValidate(String str) {
        Integer purchaseAmount = lottoNumberValidate(str);
        multipleOfLottoPriceValidate(purchaseAmount);
    }

    public void winningNumberValidate(List<String> winningNumbers) {
        lottoNumberCountValidate(winningNumbers);
        duplicateElementValidate(winningNumbers);
        for (String winningNumberString : winningNumbers) {
            Integer winningNumber = lottoNumberValidate(winningNumberString);
            numberRangeValidate(winningNumber);
        }
    }

    public void bonusNumberValidate(List<Integer> winningNumbers, String str) {
        Integer bonusNumber = lottoNumberValidate(str);
        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ERROR + DUPLICATE_ELEMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }


    public void lottoNumberCountValidate(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            System.out.println(ERROR + NUMBER_COUNT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public Integer lottoNumberValidate(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + ONLY_NUMBER_ALLOWED_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void multipleOfLottoPriceValidate(Integer lottoPrice) {
        if (lottoPrice % LOTTO_PRICE != 0) {
            System.out.println(ERROR + LOTTO_PRICE_MUST_BE_MULTIPLE_OF_1000_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void numberRangeValidate(Integer lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            System.out.println(ERROR + LOTTO_RANGE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void duplicateElementValidate(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            long count = winningNumbers.stream().filter(number -> number.equals(winningNumber)).count();
            if (count != 1) {
                System.out.println(ERROR + DUPLICATE_ELEMENT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

}
