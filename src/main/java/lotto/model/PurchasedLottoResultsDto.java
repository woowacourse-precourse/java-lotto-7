package lotto.model;

import java.util.List;

public record PurchasedLottoResultsDto(
	List<PurchasedLottoResultDto> purchasedLottoResults
) {

	public static PurchasedLottoResultsDto from(LottoBundle lottoBundle) {
		return new PurchasedLottoResultsDto(getPurchasedLottoResultDto(lottoBundle));
	}

	private static List<PurchasedLottoResultDto> getPurchasedLottoResultDto(LottoBundle lottoBundle) {
		return lottoBundle.getLottos().stream()
				.map(lotto -> PurchasedLottoResultDto.from(lotto.getNumbers()))
				.toList();
	}
}
