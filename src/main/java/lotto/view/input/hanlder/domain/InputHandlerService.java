package lotto.view.input.hanlder.domain;

import java.util.function.Function;

public interface InputHandlerService {
    <R> R retrieveReceive(Function<String, R> function);
}
