package lotto;

import NumberGenerator.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private final int oneLottoPrice = 1000;
    private final int zeroNumber = 0;
    private final RandomNumber randomNumber;

    public LottoFactory(RandomNumber randomNumber){
        this.randomNumber = randomNumber;
    }

    public Lotto createRandomLotto(){
        List<Integer> numbers = randomNumber.randomLottoNumbers();
        return new Lotto(numbers);
    }

    public List<Lotto> createRandomLottos(int number){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0 ; i < number; i++){
            lottos.add(createRandomLotto());
        }

        return lottos;
    }

    public int numberOfLotto(int lottoPrice){
        canPurchaseLotto(lottoPrice);
        return lottoPrice / oneLottoPrice;
    }

    private void canPurchaseLotto(int lottoPrice){
        if(lottoPrice % oneLottoPrice != zeroNumber)
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위입니다.");
    }

}
