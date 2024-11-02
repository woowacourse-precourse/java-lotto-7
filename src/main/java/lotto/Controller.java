package lotto;

import lotto.view.*;
import java.util.List;

public class Controller {
    InputView input = new InputView();
    OutputView output = new OutputView();
    Service service = new Service();

    int money = 0;
    public int sheets = 0;
    public List<List<Integer>> lottos;
    int[] winningNum;
    int bonusNum;

    public void start (){
        money = input.getMoney();
        sheets = money / 1000;
        lottos = service.generator(sheets);
        output.printGeneratedNum(lottos);
        winningNum = input.getWinningNum();
        bonusNum = input.getBonusNum();
    }
    // TODO: 당첨 여부 확인 및 금액 계산
    // TODO: 총 이익률 계산
}
