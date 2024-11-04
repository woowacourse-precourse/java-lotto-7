package lotto.model;

import camp.nextstep.edu.missionutils.*;

import java.util.List;

public class LottoGenerator {

    public static Lotto generateLotto() {

        List<LottoNumber> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(lottoNumbers);
    }
}
