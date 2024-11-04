package lotto.endpoint.input;

import java.util.function.Function;
import lotto.common.Displayable;

public interface InputHandler {
    <T> T handleInput(Displayable message, Function<String, T> parser);
}
