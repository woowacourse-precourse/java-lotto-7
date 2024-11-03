package lotto.config;

import static java.lang.String.format;

public interface ErrorMessage {

    String PREFIX_ERROR = "[ERROR]";
    String PREFIX_WARNING = "[WARNING]";
    String NUMBER_INSUFFICIENT = format("%s 로또 번호는 %d개여야 합니다.", PREFIX_ERROR, SystemConfig.NUMBERS);
    String DUPLICATE = format("%s 숫자는 중복될 수 없습니다.", PREFIX_ERROR);
    String NEGATIVE_DIGIT = format("%s 음수는 허용되지 않습니다.", PREFIX_ERROR);
    String NOT_DIGIT = format("%s 오직 숫자만 허용됩니다.", PREFIX_ERROR);
    String DOMAIN = format("%s 허용 범위를 초과할 수 없습니다.", PREFIX_ERROR);
    String BUDGET_UNIT = format("%s 예산은 %d원 단위로 입력할 수 있습니다.", PREFIX_ERROR, SystemConfig.LOTTO_COST);
    String NOT_VALID_INPUT = format("%s 올바른 입력이 아닙니다, 다시 입력해주세요.", PREFIX_ERROR);
    String STOP = format("%s 프로그램을 종료합니다.", PREFIX_WARNING);
}
