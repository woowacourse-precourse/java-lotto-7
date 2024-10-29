package lotto.view.input.hanlder.infrastructure;

import lotto.view.input.domain.InputService;
import lotto.view.input.hanlder.domain.InputHandlerService;

import java.util.function.Function;

public class MoneyHandler implements InputHandlerService {

    private final InputService inputService;
    public MoneyHandler(InputService inputService) {
        this.inputService = inputService;
    }

    @Override
    public <R> R retrieveReceive(Function<String, R> function) {
        try {
            String input = inputService.input();
            return function.apply(input);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return retrieveReceive(function);
        }
    }
}
