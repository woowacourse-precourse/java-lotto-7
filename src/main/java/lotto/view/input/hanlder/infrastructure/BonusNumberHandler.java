package lotto.view.input.hanlder.infrastructure;

import lotto.view.input.domain.InputService;
import lotto.view.input.hanlder.domain.InputHandlerService;

import java.util.function.Function;

public class BonusNumberHandler implements InputHandlerService {
    private final InputService inputService;

    public BonusNumberHandler(InputService inputService) {
        this.inputService = inputService;
    }

    @Override
    public <R> R retrieveReceive(Function<String, R> function) {
        String input = inputService.input();
        return function.apply(input);
    }
}
