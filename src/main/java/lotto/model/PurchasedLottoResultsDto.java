package lotto.model;

import java.util.List;

public record PurchasedLottoResultsDto(
	List<PurchasedLottoResultDto> purchasedLottoResults
) {
}
