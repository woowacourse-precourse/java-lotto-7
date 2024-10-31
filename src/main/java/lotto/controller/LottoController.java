package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.Request;

public class LottoController {

    private final Request request = new Request();
    private final LottoService lottoService = new LottoService();

    public void buyLotto() {
        int amount;
        try {
            amount = Integer.parseInt(request.inputAmount());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능 합니다.");
        }

        lottoService.buyLotto(amount);
    }
}
