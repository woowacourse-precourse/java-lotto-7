package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.constant.UtilConstants.LOTTO_NUMBER_COUNT;
import static lotto.constant.UtilConstants.MINIMUM_PRICE;

public class LottoGame {
    private final LottoRepository lottoRepository;
    private final Lotto userLotto;
    private int bonusNumber;
    private int lottoCount;

    public LottoGame(LottoRepository lottoRepository, Lotto userLotto, int bonusNumber, int inputCost){
        this.lottoRepository = lottoRepository;
        this.userLotto = userLotto;
        this.bonusNumber = bonusNumber;
        this.lottoCount = inputCost/MINIMUM_PRICE;
    }

    public void generateLotto(){
        for(int i = 0; i< lottoCount; i++){
            lottoRepository.saveLotto(generateSingleLotto());
        }
    }

    private static Lotto generateSingleLotto(){
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1,45, LOTTO_NUMBER_COUNT);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }
}
