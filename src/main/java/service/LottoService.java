package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import model.Rank;

import java.util.*;

import static service.Constants.*;

public class LottoService {

    private final static Validator validator = new Validator();

    public int purchaseAmount(String input){
        int amount = validator.validateNumber(input);
        validator.validateAmountCount(amount);
        return amount;
    }

    public List<Lotto> publishLotto(int count){
        List<Lotto> lottoList = new ArrayList<>(count);
        for(int i = 0; i < count; i++){
            lottoList.add(createLottoNumber());
        }
        return lottoList;
    }

    private Lotto createLottoNumber(){
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_COUNT));
        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public Lotto inputWinningNumber(String winningNumber){
        validator.validateEmpty(winningNumber);
        validator.validateDelimiter(winningNumber);
        List<Integer> numbers = splitWinningNumber(winningNumber);
        validator.validateDuplicatedWinningNumber(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> splitWinningNumber(String winningNumber){
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int bonusNumber(String inputBonusNumber, Lotto lotto){
        validator.validateEmpty(inputBonusNumber);
        int bonusNumber = validator.validateNumber(inputBonusNumber);
        validator.validateDuplicatedBonusNumber(bonusNumber, lotto);
        return bonusNumber;
    }

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

    public double totalReturn(Map<Rank, Integer> rankCount, int purchaseAmount){
        long sum = 0;
        for(Rank rank : Rank.values()){
            sum += (long) rank.amount * rankCount.get(rank);
        }
        return (double) sum / purchaseAmount * 100;
    }
}
