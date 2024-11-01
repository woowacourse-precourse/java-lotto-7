package lotto.core.service;

import java.util.ArrayList;
import java.util.List;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.model.Lotto;

public class PublishLottoService {

    public List<LottoDto> publish(LottoPurchaseAmountDto amount) {
        int count = amount.lottoCount();
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = createLottoUntilSuccess();
            lottoDtos.add(new LottoDto(lotto.getNumbers()));
        }
        return lottoDtos;
    }

    private Lotto createLottoUntilSuccess() {
        while (true) {
            Lotto lotto = this.createLotto();
            if (lotto != null) return lotto;
        }
    }

    private Lotto createLotto() {
        try {
            List<Integer> randoms = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
            return new Lotto(randoms);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }
}
