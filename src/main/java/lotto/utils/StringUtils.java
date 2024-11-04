package lotto.utils;

import lotto.common.ErrorMessage;

public class StringUtils {

	public StringUtils() {
	}

	public static int toNumber(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
		}
	}
}
