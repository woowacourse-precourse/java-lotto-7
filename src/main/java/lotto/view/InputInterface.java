package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputInterface {
	public String readLine() {
		String value = Console.readLine();
		if(value.isBlank()) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY.toString());
		}
		return value;
	}
}
