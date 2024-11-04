package lotto.domain;

import java.util.List;

public class Lottos {

	private final List<Lotto> lottos;

	private Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static Lottos from(List<List<Integer>> numbers) {
		List<Lotto> lottos = numbers.stream()
			.map(Lotto::new)
			.toList();

		return new Lottos(lottos);
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
