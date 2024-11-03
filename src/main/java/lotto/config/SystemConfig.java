package lotto.config;

import static java.lang.String.format;

public interface SystemConfig {
    int DOMAIN_START = 1;
    int DOMAIN_END = 45;
    int NUMBERS = 6;
    int LOTTO_COST = 1000;
    String DELIMITER = ",";
    String NUMBER_PATTERN = "^[+-]?\\d+$";
    String LIST_PATTERN = format("^(?:\\d+%s){%d}\\d+$", DELIMITER, (NUMBERS - 1));
}
