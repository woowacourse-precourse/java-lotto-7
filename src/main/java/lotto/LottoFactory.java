package lotto;

import NumberGenerator.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

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


}
