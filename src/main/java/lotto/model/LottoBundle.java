package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoBundle {

	private static final int SINGLE_LOTTO_PRICE = 1000;

	private final List<Lotto> lottos;
	private final Price price;

	public LottoBundle(Price price, LottoCreator lottoCreator) {
		this.price = price;
		this.lottos = createLotto(getCount(), lottoCreator);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getCount() {
		return price.getPrice() / SINGLE_LOTTO_PRICE;
	}

	public String getProfitRate(Map<Winning, Integer> winningResult) {
		return price.getProfitRate(winningResult);
	}

	private List<Lotto> createLotto(int count, LottoCreator lottoCreator) {
		return Stream.generate(lottoCreator::createPurchasedLotto)
				.limit(count)
				.toList();
	}
}
