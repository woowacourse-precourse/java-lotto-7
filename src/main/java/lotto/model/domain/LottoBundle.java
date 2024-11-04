package lotto.model.domain;

import java.util.List;

public record LottoBundle(List<Lotto> lottoBundle) {
	public static LottoBundle of(List<Lotto> lottoBundle) {
		return new LottoBundle(lottoBundle);
	}
}
