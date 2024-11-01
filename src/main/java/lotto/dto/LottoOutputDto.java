package lotto.dto;

import lotto.domain.LottoResult;

public record LottoOutputDto(double rateOfReturn, LottoResult lottoResult) {
}
