package lotto.domain;

import java.util.List;
import lotto.dto.Lotto;

public class RandomLottoResult {
    private List<Lotto> lottos;

    public RandomLottoResult(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public void printResult(){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
