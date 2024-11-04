package lotto.view.input.infrastructure;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.service.InputService;
import lotto.view.input.validator.InputValidator;
import lotto.view.output.service.InfoViewService;

public class WinningLottoInput implements InputService {
    private final InfoViewService viewService;
    public WinningLottoInput(InfoViewService viewService) {
        this.viewService = viewService;
    }
    @Override
    public String input() {
        viewService.view();
        String input = Console.readLine();
        InputValidator.winningLottoValidate(input);
        return input;
    }
}
