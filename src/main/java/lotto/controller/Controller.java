package lotto.controller;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final LottoService lottoService = new LottoService();

    public void run() {
        Money money = lottoService.getMoney();

        // 구입 금액에 따른 로또 개수 테스트
        System.out.println("로또 개수: " + money.getLottoTicket());

        Lottos lottos = purchaseLottos(money);
        System.out.println(lottos.getSize());
    }

    private Lottos purchaseLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < money.getLottoTicket(); i++) {
            Lotto lotto = LottoGenerator.createLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
