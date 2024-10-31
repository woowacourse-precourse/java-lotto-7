package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

	private InputHandler() {
	}

	private static class Holder {
		private static final InputHandler INSTANCE = new InputHandler();
	}

	public static InputHandler getInstance() {
		return Holder.INSTANCE;
	}

	public String readLine() {
		return Console.readLine();
	}
}
