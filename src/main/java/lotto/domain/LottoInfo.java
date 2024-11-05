package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoInfo {
    private final Lotto lotto;

    public LottoInfo(final Lotto lotto) {
        this.lotto = lotto;
    }

    public List<LottoNumber> lottoNumbers() {
        return lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
