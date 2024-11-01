package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;

public class InputView {

    private static final String EMPTY_INPUT = "";

    public String inputContent() {
        Optional<String> input = Optional.of(Console.readLine());
        return input.orElse(EMPTY_INPUT);
    }
}
