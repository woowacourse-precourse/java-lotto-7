package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class RequestView {

	private static final RequestView INSTANCE = new RequestView();

	private RequestView() {
	}

	public static RequestView getInstance() {
		return INSTANCE;
	}

	public String inputWithMessage(String message) {
		System.out.println(message);
		return Console.readLine();
	}
}
