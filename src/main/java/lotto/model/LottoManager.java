package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Validator.DELIMITER;
import static lotto.model.LottoRank.getLottoRank;

public class LottoManager {
    public Lotto generateLottoNumbers() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    public Lotto parseWinningNumbersToLotto(String winningNumbers) {
        List<Integer> numberList = Arrays.stream(winningNumbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(numberList);
    }

    // 로또sets, 당첨번호, 보너스번호를 인자로 받고 로또의 결과값들을 당첨결과 List에 추가하여 반환한다.
    public List<LottoRank> analyzeLottoResults(List<Lotto> lottoSets, Lotto winningNumbers, int bonusNumber){
        List<LottoRank>lottoRankResults = new ArrayList<>();
        boolean hasBonusNumber = false;
        for(Lotto currentLottoNumbers : lottoSets){
            int hitCount = countHitCount(currentLottoNumbers.getLotto(),winningNumbers.getLotto());
            if(hitCount==5 && checkHasBonusNumber(currentLottoNumbers.getLotto(),bonusNumber)){
                hasBonusNumber = true;
            }
            lottoRankResults.add(getLottoRank(hitCount,hasBonusNumber));
        }
        return lottoRankResults;
    }

    private boolean checkHasBonusNumber(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }


    private int countHitCount(List<Integer> currentLottoNumbers, List<Integer> winningNumbers) {
        int hitCount = 0;
        for(int number : currentLottoNumbers){
            if(winningNumbers.contains(number)){
                hitCount++;
            }
        }
        return hitCount;
    }


}
