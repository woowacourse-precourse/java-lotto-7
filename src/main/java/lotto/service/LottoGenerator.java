package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.config.SystemConfig;
import lotto.model.Lotto;

public class LottoGenerator implements Generator {
    @Override
    public Lotto generate() {
        int START = SystemConfig.DOMAIN_START;
        int END = SystemConfig.DOMAIN_END;
        int NUMBERS = SystemConfig.NUMBERS;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START, END, NUMBERS);
        return new Lotto(numbers);
    }

    @Override
    public List<Lotto> generates(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return lottos;
    }
}
