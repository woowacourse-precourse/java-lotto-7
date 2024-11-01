package lotto.model;

import java.util.List;

public class LottoBundle {

	private static final int SINGLE_LOTTO_PRICE = 1000;

	private final List<Lotto> lottos;
	private final int count;

	public LottoBundle(List<Lotto> lottos, Price price) {
		this.lottos = lottos;
		this.count = calculateCount(price.getPrice());
	}

	private int calculateCount(int price) {
		return price / SINGLE_LOTTO_PRICE;
	}
}
