package lotto.view;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class InputInterface {
	public String readLine() {
		try {
			return Console.readLine();
		} catch (NoSuchElementException exception) {
			throw new IllegalArgumentException(exception);
		}
	}
}
