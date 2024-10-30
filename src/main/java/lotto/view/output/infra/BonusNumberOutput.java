package lotto.view.output.infra;

import lotto.view.output.domain.InfoViewService;

public class BonusLottoOutput implements InfoViewService {

    @Override
    public void view() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
