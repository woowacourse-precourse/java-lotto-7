package lotto.controller;

import lotto.domain.CorrectDTO;
import lotto.domain.LottoDTO;
import lotto.domain.MoneyDTO;
import lotto.domain.RateOfReturnDTO;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;
    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    //금액을 입력받아서 처리하는 기능
    public MoneyDTO getMoneyAndReturn(){
        lottoView.printMoneyInput();
        return lottoView.getMoneyInput();
    }

    //당첨번호부터 보너스번호까지 입력받는 기능
    public CorrectDTO getCorrectNumAndBonusNum () {
        lottoView.printCorrect();
        CorrectDTO  correctDTO = lottoView.getLottoNumberInput();
        lottoView.printBonus();
        lottoView.getBonusInput(correctDTO);
        return correctDTO;
    }

    //로또를 생성해서 당첨번호와 비교하고 출력하는 기능
    public void matchNumberAndBonusNum() {
        MoneyDTO moneyDTO = getMoneyAndReturn();
        lottoView.printTicketNumber(moneyDTO);
        LottoDTO lottoDTO = lottoService.makeLottos(moneyDTO);
        lottoView.printLottos(lottoDTO);
        CorrectDTO correctDTO = getCorrectNumAndBonusNum();
        lottoService.countMatchingNumbers(correctDTO,lottoDTO);
        RateOfReturnDTO rateOfReturnDTO = lottoService.calculateRateOfReturn(moneyDTO);
        lottoView.printResult(rateOfReturnDTO);
    }

   public void playLotto(){
        matchNumberAndBonusNum();
   }


}
