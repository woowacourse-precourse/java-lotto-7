package lotto;

public class Constants {
    static final String INFORM_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    static final String INFORM_TICKET_NUMBERS = "개를 구매했습니다.";
    static final String INFORM_INPUT_USER_PICK_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INFORM_INPUT_USER_PICK_BONUS = "보너스 번호를 입력해 주세요.";
    static final String INFORM_STATISTICS = "당첨 통계\n---";
    static final String FORM_ERROR_MESSAGE = "[ERROR] ";
    static final String FORM_RANKS_NORMAL_MESSAGE = "%d개 일치 (%s원) - %d개%n";
    static final String FORM_RANKS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
    static final String INPUT_ERROR_EMPTY = "값이 입력되지 않았습니다.";
    static final String INPUT_ERROR_ONLY_DIGIT = "숫자만 입력 가능합니다.";
    static final String INPUT_ERROR_ONLY_DIGIT_COMMA = "숫자와 쉼표만 입력 가능합니다.";
    static final String INPUT_ERROR_AMOUNT_RANGE = "금액 범위는 1000부터 10000까지 입력 가능합니다.";
    static final String INPUT_ERROR_AMOUNT_UNIT = "금액은 1000 단위로 입력 가능합니다.";
    static final String INPUT_ERROR_NUMBER_COUNT = "6개의 숫자를 입력해야 합니다.";
    static final String INPUT_ERROR_NUMBER_RANGE = "숫자 범위는 1부터 45까지 입력 가능합니다.";
    static final String INPUT_ERROR_NUMBER_UNIQUE = "숫자는 중복되지 않아야 합니다.";

    static final int AMOUNT_MIN = 1000;
    static final int AMOUNT_MAX = 10000;
    static final int AMOUNT_UNIT = 1000;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;
    static final int NUMBER_COUNT = 6;
}