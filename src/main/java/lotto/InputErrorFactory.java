package lotto;

/**
 * 잘못된 입력값의 종류에 따라 에러 메세지가 포함된 IllegalArgumentException을 생성하는 클래스입니다.
 */
public class InputErrorFactory {
    private static final String ERROR_PREFIX = "[ERROR]";
    
    private static final String MESSAGE_PURCHASE_COST_NOT_NUMBER = ERROR_PREFIX + " 구입 금액은 숫자여야 합니다.";
    private static final String MESSAGE_PURCHASE_COST_TOO_LOW = ERROR_PREFIX + " 구입 금액은 1,000원 이상이어야 합니다.";
    private static final String MESSAGE_PURCHASE_COST_NOT_THOUSANDS = ERROR_PREFIX + " 구입 금액은 1,000원 단위여야 합니다.";

    private static final String MESSAGE_LOTTO_NUMBER_NOT_NUMBER = ERROR_PREFIX + " 로또 번호는 숫자여야 합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_INVALID = ERROR_PREFIX + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_SIZE_INCORRECT = ERROR_PREFIX + " 로또 번호는 6개여야 합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_DUPLICATED = ERROR_PREFIX + " 로또 번호는 중복되지 않아야 합니다.";
    
    /**
     * 입력값의 오류 타입에 따른 IllegalArgumentException을 생성합니다.
     * @param invalidType 오류 타입
     * @return 메세지가 담긴 IllegalArgumentException
     */
    public static RuntimeException getErrorWithMessage(InvalidInputType invalidType) {
        if (invalidType == InvalidInputType.PURCHASE_COST_NOT_NUMBER) {
            return new IllegalArgumentException(MESSAGE_PURCHASE_COST_NOT_NUMBER);
        }
        if (invalidType == InvalidInputType.PURCHASE_COST_TOO_LOW) {
            return new IllegalArgumentException(MESSAGE_PURCHASE_COST_TOO_LOW);
        }
        if (invalidType == InvalidInputType.PURCHASE_COST_NOT_THOUSANDS) {
            return new IllegalArgumentException(MESSAGE_PURCHASE_COST_NOT_THOUSANDS);
        }

        if (invalidType == InvalidInputType.LOTTO_NUMBER_NOT_NUMBER) {
            return new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_NOT_NUMBER);
        }
        if (invalidType == InvalidInputType.LOTTO_NUMBER_SIZE_INCORRECT) {
            return new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_SIZE_INCORRECT);
        }
        if (invalidType == InvalidInputType.LOTTO_NUMBER_DUPLICATED) {
            return new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_DUPLICATED);
        }
        if (invalidType == InvalidInputType.LOTTO_NUMBER_INVALID) {
            return new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_INVALID);
        }
        
        return new UnsupportedOperationException(invalidType.toString() + " 오류의 처리는 아직 구현되지 않았습니다!");
    }
}
