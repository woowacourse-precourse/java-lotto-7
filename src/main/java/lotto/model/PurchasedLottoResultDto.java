package lotto.model;

import java.util.List;

public record PurchasedLottoResultDto(
	List<String> purchasedLottoResult
) {

	public static PurchasedLottoResultDto from(List<LottoNumber> numbers) {
		return new PurchasedLottoResultDto(getPurchaseLottoResult(numbers));
	}

	private static List<String> getPurchaseLottoResult(List<LottoNumber> numbers) {
		return numbers.stream()
				.map(LottoNumber::getNumber)
				.map(String::valueOf)
				.toList();
	}
}
