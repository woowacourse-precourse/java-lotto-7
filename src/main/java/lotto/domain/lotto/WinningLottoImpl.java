package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;

import java.util.List;

public record WinningLottoImpl(List<LottoNumber> basicNumbers, LottoNumber bonusNumber) {
    public static WinningLottoImpl of(List<Integer> numbers, int bonusNumber) {
        return new WinningLottoImpl(null, null);
    }
}
