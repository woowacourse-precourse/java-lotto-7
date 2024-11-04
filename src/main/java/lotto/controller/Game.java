package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.service.Calculating;
import lotto.service.Issuing;
import lotto.service.Ranking;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;


public class Game {

    private LottoTicket lottoTicket;
    private WinningLotto winLotto;

    public void run() {
        try {
            before();
            start();
            end();
        }
        catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }

    }

    private void before() {
        Input.askPrice();
        lottoTicket = new LottoTicket(Input.number());
        Output.printCount(lottoTicket.getCount());
    }
    private void start(){
        Issuing.lottoTickets(lottoTicket);
        for(Lotto lotto : lottoTicket.getLottoTickets()){
            Output.printNumbers(lotto.getNumbers());
        }
        Input.askWinNumbers();
        List<Integer> winNumbers = Input.numbers();
        Input.askBonusNumber();
        winLotto = new WinningLotto(winNumbers,Input.number());
    }
    private void end(){
        Ranking.matchLotto(lottoTicket,winLotto);
        Output.printResult(lottoTicket.getResult());
        Output.printEarningRate(Calculating.earningRate(lottoTicket));
    }
}

