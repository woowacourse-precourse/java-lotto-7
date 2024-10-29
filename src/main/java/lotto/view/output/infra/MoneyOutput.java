package lotto.view.output.infra;

import lotto.view.output.domain.ViewService;

public class MoneyOutput implements ViewService {

    @Override
    public void view() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
