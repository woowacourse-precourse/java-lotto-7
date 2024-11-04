package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Spliter {
	private static final String COMMA = ",";

	public static List<String> splitByComma(String value) {
		return Arrays.stream(value.split(COMMA)).toList();
	}
}
