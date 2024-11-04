package lotto.model;

import java.util.List;

public record PurchasedLottoResultsDto(
	List<PurchasedLottoResultDto> purchasedLottoResults
) {

	private static List<PurchasedLottoResultDto> getPurchasedLottoResultDto(LottoBundle lottoBundle) {
		return lottoBundle.getLottos().stream()
				.map(lotto -> PurchasedLottoResultDto.from(lotto.getNumbers()))
				.toList();
	}
}
