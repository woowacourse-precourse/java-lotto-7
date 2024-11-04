package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int price){
        purchaseLotto(price);
    }

    public void purchaseLotto(int price){
        int NumsLotto = price / 1000;
        for(int i=0; i<NumsLotto; i++){
            lottos.add(LottoGenerator.generate());
        }
    }

    public void printLottos(){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
