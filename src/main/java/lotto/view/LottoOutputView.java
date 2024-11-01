package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class LottoOutputView {
    public int outputNumberOfLottoOutput(int lottoAmount) {
        int lottoTickets = lottoAmount / 1000;
        System.out.println(lottoTickets + "개를 구매했습니다.");
        return lottoTickets;
    }

    public void outputMakeRandomLottos(int count) {
        List<Lotto> lottos = Lotto.makeRandomLottos(count);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.lottoNumbers());
        }
    }
}
