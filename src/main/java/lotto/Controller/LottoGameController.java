package lotto.Controller;

import lotto.DTO.BonusNumberDTO;
import lotto.DTO.LottoStatisticsDTO;
import lotto.DTO.PaymentPriceDTO;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.DTO.WinningNumberDTO;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {
    private LottoService lottoService;
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        PaymentPriceDTO paymentPriceDTO = inputView.inputPaymentPrice();

        RandomLottoNumberDTO randomLottoNumberDTO = lottoService.purchaseLotto(paymentPriceDTO);

        outputView.outputRandomLottoNumber(randomLottoNumberDTO);

        WinningNumberDTO winningNumberDTO = inputView.inputWinningNumber();
        BonusNumberDTO bonusNumberDTO = inputView.inputBonusNumber(winningNumberDTO);

        LottoStatisticsDTO lottoStatisticsDTO = lottoService.calculatePrizeMoney(winningNumberDTO, bonusNumberDTO,
                randomLottoNumberDTO);
    }
}
