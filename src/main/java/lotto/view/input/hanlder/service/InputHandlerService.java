package lotto.view.input.hanlder.service;

import java.util.function.Function;

public interface InputHandlerService {
    <R> R retrieveReceive(Function<String, R> function);
}
