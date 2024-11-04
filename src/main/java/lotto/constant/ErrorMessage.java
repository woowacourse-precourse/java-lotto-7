package lotto.constant;

import static lotto.constant.Digit.*;
import static lotto.constant.Regex.*;

public class ErrorMessage {
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_NUMBER_COUNT = NUMBER_COUNT + "개여야 합니다.";
	
	public static final String IS_NOT_NUMBER = ERROR + "숫자만 입력 가능합니다.";
	public static final String IS_NOT_MULTIPLE_OF_THOUSAND = ERROR + "1000으로 나누어 떨어지지 않습니다.";
	public static final String INVALID_LOTTO_NUMBERS_COUNT = ERROR + "로또 번호는 " + INVALID_NUMBER_COUNT;
	public static final String INVALID_WINNING_NUMBERS_COUNT = ERROR + "당첨 번호는 " + INVALID_NUMBER_COUNT;
	public static final String CANNOT_SPLIT_BY_SEPARATOR = ERROR + SEPARATOR + "로 구분할 수 없습니다.";
	public static final String INVALID_RANGE = ERROR + "로또 번호는 "+ START_NUMBER + "부터 " + END_NUMBER + " 사이의 숫자여야 합니다.";
	public static final String DUPLICATED_NUMBERS = ERROR + "중복되는 숫자가 존재합니다.";
	public static final String WINNING_NUMBERS_CONTAIN_BONUS_NUMBER = ERROR + "당첨 번호에 이미 존재하는 숫자입니다.";
}
