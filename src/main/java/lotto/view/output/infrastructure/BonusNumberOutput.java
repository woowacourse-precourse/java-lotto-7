package lotto.view.output.infrastructure;

import lotto.view.output.domain.Message;
import lotto.view.output.service.InfoViewService;

public class BonusNumberOutput implements InfoViewService {

    @Override
    public void view() {
        Message.BONUS_NUMBER_PROMPT.print();
    }
}
