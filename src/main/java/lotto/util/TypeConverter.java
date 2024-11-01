package lotto.util;

import lotto.exception.ExceptionMessage;

public class TypeConverter {
	public static int convertStringToInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.toString());
		}
	}
}
