package lotto.view.input.infra;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.input.domain.InputService;
import lotto.view.output.domain.InfoViewService;

public class BonusLottoInput implements InputService {
    private final InfoViewService viewService;
    public BonusLottoInput(InfoViewService viewService) {
        this.viewService = viewService;
    }
    @Override
    public String input() {
        viewService.view();
        String input = Console.readLine();
        return input;
    }
}
