package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void printLottoNumber(int number){
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos){
        for(Lotto l : lottos){
            System.out.println(l);
        }
    }

}
