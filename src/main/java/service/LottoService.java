package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static service.Constants.*;

public class LottoService {
    private final static Validator validator = new Validator();

    public int lottoCount(int amount){
        validator.validateAmount(amount);
        return amount/1000;
    }

    public List<Lotto> publishLotto(int count){
        List<Lotto> lottoList = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            lottoList.add(createLottoNumber());
        }
        return lottoList;
    }

    private Lotto createLottoNumber(){
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN,LOTTO_MAX,LOTTO_COUNT);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    // 당첨 번호 입력 받기
    public Lotto inputWinningNumber(String winningNumber){
        validator.validateEmpty(winningNumber);
        validator.validateDelimiter(winningNumber);
        List<Integer> numbers = splitWinningNumber(winningNumber);
        validator.validateWinningNumber(numbers);
        return new Lotto(numbers);
    }

    // 당첨 번호 분리하기
    public List<Integer> splitWinningNumber(String winningNumber){
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    // 보너스 번호 입력 받기
    public int bonusNumber(Integer bonusNumber, Lotto lotto){
        validator.validateEmpty(bonusNumber);
        validator.validateBonusNumber(bonusNumber, lotto);
        return bonusNumber;
    }

    // 당첨 통계 내기
    public Map<Rank, Integer> calculateStatistics(List<Lotto> lottoList,  Lotto winningLotto, int bonusNumber){
        Map<Rank, Integer> rankCount = new HashMap<>();
        for(Rank rank : Rank.values()){
            rankCount.put(rank, 0);
        }
        for(Lotto lotto : lottoList){
            Rank rank = determineRank(lotto, winningLotto, bonusNumber);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
        return rankCount;
    }

    // 등수 결정
    private Rank determineRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        if (matchCount == 6) return Rank.FIRST;
        if (matchCount == 5 && bonusMatch) return Rank.SECOND;
        if (matchCount == 5) return Rank.THIRD;
        if (matchCount == 4) return Rank.FOURTH;
        if (matchCount == 3) return Rank.FIFTH;
        return Rank.MISS;
    }

    // 총 수익률 계산하기
    public double totalReturn(Map<Rank, Integer> rankCount, int purchaseAmount){
        long sum = 0;
        for(Rank rank : Rank.values()){
            sum += (long) rank.amount * rankCount.get(rank);
        }
        return (double) sum / purchaseAmount;
    }
}
}
