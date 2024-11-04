package lotto.view.output.infrastructure;

import lotto.view.output.domain.Message;
import lotto.view.output.service.InfoViewService;

public class WinningLottoOutput implements InfoViewService {
    @Override
    public void view() {
        Message.WINNING_LOTTO_PROMPT.print();
    }
}
