package lotto.view;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputInterface {
	public String readLine() {
		try {
			return Console.readLine();
		} catch (NoSuchElementException exception) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_EMPTY.toString());
		}
	}
}
