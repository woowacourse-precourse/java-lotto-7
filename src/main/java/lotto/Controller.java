package lotto;

import lotto.view.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    Service service = new Service();

    public List<List<Integer>> lottos;
    int[] winningNum;
    static int bonusNum;
    ArrayList<Integer> winningScore;

    public void start (){
        int money = input.getMoney();
        int sheets = money / 1000;
        lottos = service.generator(sheets);
        output.printGeneratedNum(lottos);
        winningNum = input.getWinningNum();
        bonusNum = input.getBonusNum();
        winningScore = service.checkWinning(lottos, winningNum);
        int[] resultWinning = service.countWinning(winningScore);
        output.printWinning(resultWinning);
    }
    // TODO: 총 이익률 계산
}
