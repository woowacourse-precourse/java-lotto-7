package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

import static lotto.util.message.Messages.*;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void handle() {
        int price = inputView.getInput();
        // 로또 발행하기
        List<Lotto> lottoTicket = lottoService.issueLotto(price);
        printLottoStatus(lottoTicket);
        // 당첨번호 및 보너스번호 입력받기
        List<Integer> winningNumber = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

//        WinningLotto winningLotto = lottoService.issueWinningLotto(winningNumber, bonusNumber);
        // 당첨 통계 및 수익률 출력

    }

    private void printLottoStatus(List<Lotto> lottoTicket) {
        System.out.println(lottoTicket.size() + QUANTITY_OF_LOTTO);
        for(Lotto lotto:lottoTicket){
            System.out.println(lotto);
        }
        System.out.println();
    }
}
