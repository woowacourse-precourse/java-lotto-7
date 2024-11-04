package lotto.dto;

import java.util.List;

public record LottoPurchaseDto(List<LottoNumberDto> purchasedLottoNumbers) {
}