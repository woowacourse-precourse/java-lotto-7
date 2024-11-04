package lotto.back.lotto.controller;

import lotto.back.global.annotation.Controller;
import lotto.back.lotto.service.LottoService;
import lotto.global.dto.request.LottoResultRequestDTO;
import lotto.global.dto.request.PurchaseLottoRequestDTO;
import lotto.global.dto.request.SetPrizeLottoRequestDTO;
import lotto.global.dto.response.LottoResultResponseDTOs;
import lotto.global.dto.response.PurchasedLottoResponseDTOs;

@Controller
public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public PurchasedLottoResponseDTOs purchase(PurchaseLottoRequestDTO purchaseLottoRequestDTO) {
        return lottoService.purchase(purchaseLottoRequestDTO);
    }

    public void setPrizeLotto(SetPrizeLottoRequestDTO setPrizeLottoRequestDTO) {
        lottoService.setPrizeLotto(setPrizeLottoRequestDTO);
    }

    public LottoResultResponseDTOs setBonusAndGetResult(LottoResultRequestDTO lottoResultRequestDTO) {
        return lottoService.getResult(lottoResultRequestDTO);
    }

}
