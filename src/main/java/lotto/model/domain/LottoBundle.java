package lotto.model.domain;

import java.util.List;

public class LottoBundle {
	private final List<Lotto> lottoBundle;

	public LottoBundle(List<Lotto> lottoBundle) {
		this.lottoBundle = lottoBundle;
	}

	public static LottoBundle of(List<Lotto> lottoBundle) {
		return new LottoBundle(lottoBundle);
	}

	public List<Lotto> getLottoBundle() {
		return lottoBundle;
	}
}
