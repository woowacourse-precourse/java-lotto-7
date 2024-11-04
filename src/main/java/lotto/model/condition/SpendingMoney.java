package lotto.model.condition;

import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

import static lotto.utils.StringValidator.containsNotDigit;
import static lotto.utils.StringValidator.isEmpty;
import static lotto.utils.StringValidator.containsBlank;

/**
 * 로또 구매액을 보관하는 클래스
 * 주어진 문자열 검증 기능을 담당
 * 문자 형식을 검증하고 잘못된 경우 예외를 호출
 */
public class SpendingMoney {
    
    private static final String EXCEPTION_MESSAGE_OUT_OF_LONG =
            Constants.EXCEPTION_MESSAGE_PREFIX + "2의 63 제곱보다 작은 값을 입력하세요.";
    
    private static final String EXCEPTION_MESSAGE_SMALL_CHANGE_NOT_ZERO =
            Constants.EXCEPTION_MESSAGE_PREFIX +
                    "구매 금액은 " + Constants.LOTTO_TICKET_PRICE +
                    "원으로 나누어 떨어져야 합니다.";

    protected static final String EXCEPTION_MESSAGE_UNDER_MIN_NUMBER =
            Constants.EXCEPTION_MESSAGE_PREFIX +
                    "구매 금액은 " + Constants.LOTTO_TICKET_PRICE + "보다 커야 합니다.";
    
    private final long money;

    /**
     * @param 문자열(숫자)
     * @throws 숫자가 형식에 맞지 않으면 IllegalArgumentException 호출
     */
    public SpendingMoney(String numberToValidate) {
        if (isEmpty(numberToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.toString());
        }
        if (containsBlank(numberToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_INPUT.toString());
        }
        if (containsNotDigit(numberToValidate)) {
            throw new IllegalArgumentException(ExceptionMessage.NO_DIGIT_INPUT.toString());
        }
        if (isNotLongRange(numberToValidate)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OUT_OF_LONG);
        }
        if (underTicketPrice(numberToValidate)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_UNDER_MIN_NUMBER);
        }
        if (isNotModTicketPriceZero(numberToValidate)) {
           throw new IllegalArgumentException(EXCEPTION_MESSAGE_SMALL_CHANGE_NOT_ZERO);
        }
        this.money = Long.parseLong(numberToValidate);
    }

    private boolean isNotLongRange(String numberToValidate) {
        try {
            Long.parseLong(numberToValidate);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean underTicketPrice(String numberToValidate) {
        return Long.parseLong(numberToValidate) < Constants.LOTTO_TICKET_PRICE;
    }
    
    private boolean isNotModTicketPriceZero(String numberToValidate) {
        long smallChange =
                Long.parseLong(numberToValidate) % Constants.LOTTO_TICKET_PRICE;
        return smallChange != 0L;
    }
    
    public long get() {
        return money;
    }
    
}
