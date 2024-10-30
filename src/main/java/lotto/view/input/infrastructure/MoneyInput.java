package lotto.view.input.infra;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.domain.InputService;
import lotto.view.input.validator.InputValidator;
import lotto.view.output.domain.InfoViewService;

public class MoneyInput implements InputService {
    private final InfoViewService viewService;
    public MoneyInput(InfoViewService viewService) {
        this.viewService = viewService;
    }
    @Override
    public String input() {
        viewService.view();
        String input = Console.readLine();
        InputValidator.moneyValidate(input);
        return input;
    }
}
