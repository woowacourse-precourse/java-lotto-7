package lotto.controller;

import java.util.List;
import lotto.service.LottoServiceImpl;

public class LottoController {
    private static LottoController lottoController;
    private static LottoServiceImpl lottoService = LottoServiceImpl.getInstance();

    public static LottoController getInstance() {
        if (lottoController == null) {
            lottoController = new LottoController();
        }
        return lottoController;
    }

    public void buyLotto(Integer lottoCount) {
        lottoService.buyLotto(lottoCount);
    }

    public void saveWinningNumber(List<Integer> winningNumbers){
        lottoService.saveWinningNumber(winningNumbers);
    }

    public void calWinning(){
        lottoService.calWinning();
    }
}