package lotto.view.output.infrastructure;

import lotto.view.output.domain.InfoViewService;

public class MoneyOutput implements InfoViewService {

    @Override
    public void view() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
