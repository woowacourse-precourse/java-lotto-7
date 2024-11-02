package lotto.domain.lotto;

import java.util.List;

public class LottoCreator {

    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::new)
                .toList());
    }
}