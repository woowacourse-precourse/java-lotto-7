package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class LottoBundle {

	private static final int SINGLE_LOTTO_PRICE = 1000;

	private final List<Lotto> lottos;
	private final Price price;

	public LottoBundle(Price price, LottoCreator lottoCreator) {
		this.count = calculateCount(price.getPrice());
		this.lottos = createLotto(count, lottoCreator);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getCount() {
		return count;
	}

	private int calculateCount(int price) {
		return price / SINGLE_LOTTO_PRICE;
	}

	private List<Lotto> createLotto(int count, LottoCreator lottoCreator) {
		return Stream.generate(lottoCreator::createPurchasedLotto)
				.limit(count)
				.toList();
	}
}
