package lotto.model;

import java.util.List;

public class PurchaseLottoResultGenerator {

	public List<List<Integer>> generatePurchaseLottoResult(LottoBundle lottoBundle) {
		List<Lotto> lottos = lottoBundle.getLottos();
		return lottos.stream()
				.map(lotto -> getLottoNumbers(lotto.getNumbers()))
				.toList();
	}

	private List<Integer> getLottoNumbers(List<LottoNumber> numbers) {
		return numbers.stream()
				.map(LottoNumber::getNumber)
				.toList();
	}
}
