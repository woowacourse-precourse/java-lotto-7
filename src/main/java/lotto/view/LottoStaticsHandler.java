package lotto.view;

import lotto.domain.Rank;
import lotto.service.LottoService;

import java.util.List;

public class LottoStaticsHandler {
     private LottoService lottoService;

    public LottoStaticsHandler(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void displayLottoStatics(List<Rank> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
