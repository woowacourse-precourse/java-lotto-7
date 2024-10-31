package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;

public class LottoMachineController {
    User user = new User();
    InputView inputView = new InputView(user);

    public void run() {
        // 로또 발매기 실행 구현하기
        inputView.run();
    }
}
