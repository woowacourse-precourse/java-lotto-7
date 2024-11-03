package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.utils.NumberList;

public class LottoModel {

    private List<Lotto> lottoRepository;
    private NumberList numberList;

    public LottoModel(){
        this.lottoRepository = new ArrayList<Lotto>();
        this.numberList = new NumberList();
    }

    public List<Lotto> createLotto(int count){

        /*TODO
        *  - count값 양수 검증*/

        List<Lotto> createdLottos = new ArrayList<Lotto>();

        for(int i = 0; i < count; ++i){
            Lotto newLotto = this.createLotto();
            this.lottoRepository.add(newLotto);
            createdLottos.add(newLotto);
        }

        return createdLottos;
    }


    private Lotto createLotto(){
        this.numberList.generateRandomNumberList();

        Lotto newLotto = new Lotto(numberList);

        this.numberList.clear();

        return newLotto;
    }

}
