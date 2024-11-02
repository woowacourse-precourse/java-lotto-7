package lotto;

import java.util.List;

public class LottoFactory {

    private LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();

    public Lotto createRandomLotto(){
        List<Integer> numbers = lottoRandomNumber.randomLottoNumbers();
        return new Lotto(numbers);
    }

}
