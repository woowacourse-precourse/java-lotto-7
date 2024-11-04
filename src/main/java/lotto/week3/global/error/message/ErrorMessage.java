package lotto.week3.global.error.message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ErrorMessage {

    // 입력 관련 오류 메시지
    INPUT_IS_EMPTY("입력", "[ERROR] 입력이 비었습니다. 금액을 입력해 주세요."),
    PLEASE_ENTER_THE_AMOUNT_IN_NUMBERS("입력", "[ERROR] 금액은 숫자로 입력해 주세요."),
    MINIMUM_PURCHASE_AMOUNT("입력", "[ERROR] 최소 구입 금액은 1,000원입니다."),
    PURCHASE_AMOUNT("입력", "[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요."),

    // 로또 번호 생성기 관련 오류 메시지
    LOTTO_NUMBERS_CANNOT_BE_NULL("로또번호생성기", "로또 번호는 null일 수 없습니다."),
    LOTTO_NUMBERS_CANNOT_BE_EMPTY("로또번호생성기", "로또 번호는 비어 있을 수 없습니다."),
    LOTTO_NUMBERS_MUST_BE_SIX("로또번호생성기", "로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_MUST_NOT_BE_DUPLICATED("로또번호생성기", "로또 번호는 중복되지 않아야 합니다."),
    LOTTO_NUMBERS_MUST_BE_BETWEEN_1_AND_45("로또번호생성기", "로또 번호는 1부터 45 사이여야 합니다."),

    // 당첨 번호 관련 오류 메시지
    WINNING_NUMBER_MUST_BE_SIX("당첨번호", "[ERROR] 당첨 번호는 6자리여야 합니다."),
    WINNING_NUMBER_MUST_BE_UNIQUE_AND_IN_RANGE("당첨번호", "[ERROR] 당첨 번호는 1부터 45 사이의 고유한 숫자여야 합니다."),
    BONUS_NUMBER_MUST_BE_UNIQUE_AND_IN_RANGE("보너스번호", "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자여야 합니다.");

    private final String category;
    private final String message;

    ErrorMessage(String category, String message) {
        this.category = category;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return message;
    }
}