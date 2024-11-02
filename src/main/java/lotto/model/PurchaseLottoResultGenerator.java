package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottoResultGenerator {

	public List<List<Integer>> generatePurchaseLottoResult(LottoBundle lottoBundle) {
		List<Lotto> lottos = lottoBundle.getLottos();
		List<List<Integer>> result = new ArrayList<>();
		for (Lotto lotto : lottos) {
			List<LottoNumber> numbers = lotto.getNumbers();
			result.add(getLottoNumbers(numbers));
		}
		return result;
	}

	private List<Integer> getLottoNumbers(List<LottoNumber> numbers) {
		return numbers.stream()
				.map(LottoNumber::getNumber)
				.toList();
	}
}
