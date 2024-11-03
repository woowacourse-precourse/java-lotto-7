package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;

public final class InputView {
    public static <T> T read(Prompt prompt, Function<String, T> handler) {
        System.out.println(prompt.getMessage());
        String input = Console.readLine();
        System.out.println();

        return handler.apply(input);
    }
}
