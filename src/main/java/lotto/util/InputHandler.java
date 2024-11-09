package lotto.util;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.function.Function;

public class InputHandler {

	public static <T> T getInput(Function<String, T> parser) {
		while (true) {
			try {
				String input = readLine();
				return parser.apply(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
