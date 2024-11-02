package lotto.model;

import java.util.List;

public class PurchaseLottoResultGenerator {

	public List<List<String>> generatePurchaseLottoResult(LottoBundle lottoBundle) {
		List<Lotto> lottos = lottoBundle.getLottos();
		return lottos.stream()
				.map(lotto -> getLottoNumbers(lotto.getNumbers()))
				.toList();
	}

	private List<String> getLottoNumbers(List<LottoNumber> numbers) {
		return numbers.stream()
				.map(LottoNumber::getNumber)
				.map(String::valueOf)
				.toList();
	}
}
