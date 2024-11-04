package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.RandomLotto;
import lotto.model.WinLotto;
import lotto.sevice.InputValidService;
import lotto.sevice.LottoService;

import java.util.List;

import static lotto.view.UserResponseView.*;

public class UserRequestController {
    InputValidService inputValidService = new InputValidService();
    LottoService lottoService = new LottoService();
    int lottoCnt;
    RandomLotto randomLotto;
    Lotto lotto;
    static int bonusNumber;
    List<Integer> winCounts;
    WinLotto[] winLotto;

    public void inputMoney(){
        startMessage();
        String money = Console.readLine();
        try{
            if(Integer.parseInt(money)%1000 != 0){
                throw new IllegalArgumentException();
            }
            lottoCnt = lottoService.countLotto(money);
            pickLotto();
            showRandomLotto();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 문제 발생");
            inputMoney();
        }
    }

    public void inputWinNumbers(){
        winLottoMessage();
        String numbers = Console.readLine();
        try{
            lotto = new Lotto(lottoService.getWinLottoList(numbers));
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 번호 입력이 잘 못 되었습니다.");
            inputWinNumbers();
        }
    }

    public void inputBonusNum(){
        bonusLottoMessage();
        String bonusNum = Console.readLine();
        try{
            bonusNumber = Integer.parseInt(bonusNum);
            winCountLotto();
            statistics();
            totalRevenue();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 로또 보너스 번호의 입력이 잘 못 되었습니다.");
            inputBonusNum();
        }

    }

    public void totalRevenue(){
        String total = lottoService.totalRevenueMoney(winLotto, winCounts, lottoCnt);
        revenueMessage(total);
    }

    public void statistics(){
        winLotto = WinLotto.values();
        int i=0;
        for(WinLotto w : winLotto){
            w.setWin(winCounts.get(i));
            i++;
        }
        lottoMessage(winLotto);
    }

    public void winCountLotto(){
        winCounts = lottoService.countWinLotto(
                randomLotto.getLotto(),
                lotto.getNumbers(),
                bonusNumber);
    }


    public void pickLotto(){
        countLottoMessage(lottoCnt);
        randomLotto = new RandomLotto(lottoCnt);
    }

    public void showRandomLotto(){
        List<List<Integer>> lotto = randomLotto.getLotto();
        for(List<Integer> ls : lotto){
            randomLottoMessage(ls);
        }
        System.out.println();
    }
}
