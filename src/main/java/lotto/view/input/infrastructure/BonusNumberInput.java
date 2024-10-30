package lotto.view.input.infra;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.domain.InputService;
import lotto.view.input.validator.InputValidator;
import lotto.view.output.domain.InfoViewService;

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
