package lotto.controller;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class RunApplication {

    private static final int TicketPrice = 1000;
    private static final int Percentage=100;
    private static InputView PlayerInputPrice;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    private static List<Lotto> makeLottoToList(int ticketCount){
        lottoList=new ArrayList<>();
        for(int i=0;i<ticketCount;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto(){
        PickRandomNumbers lottoNumbers = new PickRandomNumbers();
        lotto = new ArrayList<>();

        lotto=lottoNumbers.pickRandNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);

    }



}
