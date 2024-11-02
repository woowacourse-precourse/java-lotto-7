package controller;

import java.util.List;
import lotto.Lotto;
import service.LottoService;

public class LottoController {

    private List<Lotto> lottoList;
    private Lotto WinnerLottoNumber;
    private int lottoPurchaseAmount;
    private int lottoDrawCount;
    private LottoService lottoservice = new LottoService();

    public void run() {
        lottoPurchaseAmount = lottoservice.getLottoPurchaseAmount();
        lottoDrawCount = lottoservice.getLottoDrawCount(lottoPurchaseAmount);
        lottoList = lottoservice.generateRandomLottoNumbers(lottoDrawCount);

        lottoservice.printLottoNumbers(lottoList);
        WinnerLottoNumber = lottoservice.getWinnerLottoNumbers();
        int bonusNumber = lottoservice.getBonusNumber();



    }

}
