package lotto.view.output.infrastructure;

import lotto.view.output.domain.InfoViewService;

public class WinningLottoOutput implements InfoViewService {
    @Override
    public void view() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
