package lotto.view.input.infrastructure;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.service.InputService;
import lotto.view.input.validator.InputValidator;
import lotto.view.output.service.InfoViewService;

public class BonusNumberInput implements InputService {
    private final InfoViewService viewService;
    public BonusNumberInput(InfoViewService viewService) {
        this.viewService = viewService;
    }
    @Override
    public String input() {
        viewService.view();
        String input = Console.readLine();
        InputValidator.bonusNumberValidate(input);
        return input;
    }
}
