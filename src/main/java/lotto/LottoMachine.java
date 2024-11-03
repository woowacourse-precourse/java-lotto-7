package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {


    public List<Lotto> buyLottos(int inputPrice){
        if(inputPrice < 0) throw new IllegalArgumentException("유효한 금액이 아닙니다");

        int size = inputPrice / Lotto.PRICE;
        List<Lotto> lottos = createLottos(size);

        System.out.println(size+"개를 구매했습니다.");
        for(Lotto lotto : lottos) System.out.println(lotto.toString());

        return lottos;
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
