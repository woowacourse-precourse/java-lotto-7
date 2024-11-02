package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.UtilConstants.MINIMUM_PRICE;
import static lotto.constant.UtilConstants.RANDOM_NUMBER_START;
import static lotto.constant.UtilConstants.RANDOM_NUMBER_END;
import static lotto.constant.UtilConstants.LOTTO_NUMBER_COUNT;


public class LottoGame {
    private final LottoRepository lottoRepository;
    private boolean bonusNumberMatch = false;
    private int lottoCount;

    public LottoGame(LottoRepository lottoRepository){
        this.lottoRepository = lottoRepository;
    }

    public void setLottoCount(int purchaseAmount){
        this.lottoCount = purchaseAmount/MINIMUM_PRICE;
    }

    public void generateLotto(){
        for(int i = 0; i < lottoCount; i++){
            lottoRepository.saveLotto(generateSingleLotto());
        }
    }

    public void calculateMatchingNumbers(){
        for(Lotto lotto : lottoRepository.getLottos()){
            bonusNumberMatch = false;
            int matchingCount = calculateMatchingCount(lotto);
            decidePlace(matchingCount);
        }
    }

    private int calculateMatchingCount(Lotto lotto){
        Set<Integer> intersection = new HashSet<>(lottoRepository.getWinningLotto());
        checkIfBonusNumberMatch(intersection);
        intersection.retainAll(lotto.getNumbers());
        return intersection.size();
    }

    private void checkIfBonusNumberMatch(Set<Integer> currentLotto){
        if(currentLotto.contains(lottoRepository.getBonusNumber())){
            bonusNumberMatch = true;
        }
    }

    private void decidePlace(int matchCount){
        LottoRank rank = LottoRank.getRank(matchCount, bonusNumberMatch);
        lottoRepository.increaseCount(rank.getIndex());
        lottoRepository.increaseProfit(rank.getMoney());
    }

    private static Lotto generateSingleLotto(){
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END, LOTTO_NUMBER_COUNT);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }
}
