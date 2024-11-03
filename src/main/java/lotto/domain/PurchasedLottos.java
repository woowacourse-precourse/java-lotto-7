package lotto.domain;

import java.util.List;
import java.util.Optional;

public class PurchasedLottos {
	private final List<Lotto> purchasedLottos;

	private PurchasedLottos(List<Lotto> purchasedLottos) {
		this.purchasedLottos = List.copyOf(purchasedLottos);
	}

	public static PurchasedLottos from(List<Lotto> purchasedLottos) {
		return new PurchasedLottos(purchasedLottos);
	}

	public int getLottosSize() {
		return purchasedLottos.size();
	}

	public List<Lotto> getPurchasedLottos() {
		return purchasedLottos;
	}

	public List<Rank> compareWinningNumbers(WinningNumbers winningNumbers) {
		return purchasedLottos.stream()
			.map(lotto -> compareLotto(lotto, winningNumbers))
			.flatMap(Optional::stream)
			.toList();
	}

	private Optional<Rank> compareLotto(Lotto lotto, WinningNumbers winningNumbers) {
		int matchCount = lotto.getMatchCount(winningNumbers.getMainWinningNumbers());
		boolean matchBonus = lotto.getMatchBonus(winningNumbers.getBonusNumber());
		return Rank.of(matchCount, matchBonus);
	}
}
