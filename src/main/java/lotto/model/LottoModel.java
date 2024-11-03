package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.utils.NumberList;

public class LottoModel {

    private List<Lotto> lottoRepository;
    private Lotto winLotto;
    private int bonusNumber;

    public LottoModel(){
        this.lottoRepository = new ArrayList<Lotto>();
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



    public void setWinLottoWithBonusNumber(List<Integer> winLottoNumbers, int bonusNumber){

        NumberList newNumberList = new NumberList();
        newNumberList.addAll(winLottoNumbers);

        this.winLotto = new Lotto(newNumberList);
        this.bonusNumber = bonusNumber;


    }

    public Lotto readWinLotto(){

        return new Lotto(this.winLotto.getNumbers());
    }

    public int readBonusNumber(){
        return this.bonusNumber;
    }


    private Lotto createLotto(){
        NumberList numberList = new NumberList();
        numberList.generateRandomNumberList();

        Lotto newLotto = new Lotto(numberList);

        return newLotto;
    }

}
