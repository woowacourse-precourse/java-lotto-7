package lotto.view.input.hanlder;

import java.util.function.Function;

public interface InputHandlerService {
    <R> R retrieveReceive(String input, Function<String, R> function);
}
