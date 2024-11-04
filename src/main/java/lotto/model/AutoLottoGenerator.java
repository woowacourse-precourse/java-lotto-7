package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.InputValidator;

public class AutoLottoGenerator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int COUNT_OF_NUMBERS_INCLUDED_IN_ONE_LOTTO = 6;


    private InputValidator inputValidator;

    public AutoLottoGenerator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<Lotto> generate(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    COUNT_OF_NUMBERS_INCLUDED_IN_ONE_LOTTO);
            Lotto lotto = new Lotto(lottoNumbers, inputValidator);
            lottos.add(lotto);
        }

        return lottos;
    }
}
