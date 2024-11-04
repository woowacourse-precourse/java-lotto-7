package lotto.domain.lotto;

import java.util.List;

public class LottoCreator {

    public Lotto createLotto(List<Integer> lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .toList();
        return new Lotto(numbers);
    }
}
