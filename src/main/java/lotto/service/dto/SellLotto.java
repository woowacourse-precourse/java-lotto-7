package lotto.service.dto;

import java.util.List;
import lotto.domain.dto.LottoDetail;

public record SellLotto(
    List<LottoDetail> lottoDetails
) {

}
