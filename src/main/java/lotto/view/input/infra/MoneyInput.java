package lotto.view.input.infra;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.domain.InputService;
import lotto.view.output.domain.ViewService;

public class MoneyInput implements InputService {
    private final ViewService viewService;
    public MoneyInput(ViewService viewService) {
        this.viewService = viewService;
    }
    @Override
    public String input() {
        viewService.view();
        String input = Console.readLine();
        // TODO 예 외 처 리
        return input;
    }
}
