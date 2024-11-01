package lotto;

import lotto.view.InputView;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Controller {
    final int price = 1000;
    int money = 0;
    int sheets = 0;

    // TODO: 로또발행
    void generator(int sheets){
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0;i<sheets;i++){
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void start (){
        InputView input = new InputView(); // 1000원
        money = input.getMoney();
        sheets = money / price;
        generator(sheets);
    }

    // TODO: 당첨 여부 확인 및 금액 계산
    // TODO: 총 이익률 계산
}
