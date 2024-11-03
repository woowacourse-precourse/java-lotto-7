package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {


    public List<Lotto> buyLottos(int inputPrice){
        if(inputPrice < 0) throw new IllegalArgumentException("유효한 금액이 아닙니다");

        return createLottos(inputPrice / Lotto.PRICE);
    }

    private Lotto createRandomLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, Lotto.MAX_NUM, 6));
    }

    private List<Lotto> createLottos(int size){
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<size; i++){
            lottos.add(createRandomLotto());
        }

        return lottos;
    }
}
