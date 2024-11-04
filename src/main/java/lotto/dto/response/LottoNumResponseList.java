package lotto.dto.response;

import lotto.domain.Lotto;

import java.util.List;

public record LottoNumResponseList(
        int lottoNumCount,
        List<Lotto> lottoList
) {
    public static LottoNumResponseList of(int lottoNumCount, List<Lotto> lottoList) {
        return new LottoNumResponseList(lottoNumCount, lottoList);
    }
}
