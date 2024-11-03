package lotto.back.service;

import lotto.global.dto.request.LottoDrawRequestDTO;
import lotto.global.dto.request.LottoMatchRequestDTO;
import lotto.global.dto.request.LottoPurchaseRequestDTO;
import lotto.global.dto.response.LottoMatchResponseDTO;
import lotto.global.dto.response.LottoPurchaseResponseDTO;

public interface LottoService {
    LottoPurchaseResponseDTO issueLottos(LottoPurchaseRequestDTO lottoPurchaseRequestDTO);

    void saveDrawnNumbers(LottoDrawRequestDTO lottoDrawRequestDTO);

    LottoMatchResponseDTO matchLotto(LottoMatchRequestDTO lottoMatchRequestDTO);
}
