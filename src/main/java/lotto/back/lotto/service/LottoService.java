package lotto.back.lotto.service;

import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;

public interface LottoService {

    PurchasedLottoResponseDTOs purchase(PurchaseLottoRequestDTO purchaseLottoRequestDTO);

    void setPrizeLotto(SetPrizeLottoRequestDTO setPrizeLottoRequestDTO);
}
