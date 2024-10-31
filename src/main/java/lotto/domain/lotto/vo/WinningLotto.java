package lotto.domain.lotto.vo;

import java.util.List;

public record WinningLotto(List<LottoNumber> basicNumbers, LottoNumber bonusNumber) {

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(null, null);
    }
}
