package lotto.model;

import lotto.constant.Constants;
import lotto.constant.ErrorMessage;
import lotto.constant.Rank;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoManager {

    private PurchaseQuantity purchaseQuantity; //판매 수량

    private Lotto winningLotto; //당첨 번호 로또

    private BonusNumber bonusNumber; //보너스 번호

    private HashMap<Rank, Integer> result; //로또 결과

    private List<Lotto> lottos; //발행한 로또


    public LottoManager(){
        lottos = new ArrayList<>();
        result = new HashMap<>();
    }

    public void setPurchaseQuantity(PurchaseQuantity purchaseQuantity){
        this.purchaseQuantity = purchaseQuantity;
    }

    public PurchaseQuantity getPurchaseQuantity(){return this.purchaseQuantity;}

    public void setWinningLotto(Lotto winnigLotto){
        this.winningLotto = winnigLotto;
    }

    public void setBonusNumber(BonusNumber bonusNumber){
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(BonusNumber bonusNumber){
        if(winningLotto.getNumbers().contains(bonusNumber.getBonus())) throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WINNING_NUM.getMessage());
    }

    public List<Lotto> publishLotto(){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0;i< purchaseQuantity.getPurchaseQuantity(); i++){
            List<Integer> numbers = pickUniqueNumbersInRange(Constants.LOTTO_NUMBER_START_RANGE.getConstant(),
                    Constants.LOTTO_NUMBER_END_RANGE.getConstant(), Constants.LOTTO_SIZE.getConstant());
            List<Integer> sortedNumbers = numbers.stream()
                    .sorted()
                    .toList();
            lottoList.add(new Lotto(numbers));
        }
        setLottos(lottoList);
        return lottos;
    }

    public void setLottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public HashMap<Rank, Integer> matchingLotto(){
        initializePrize();
        for(Lotto lotto: lottos){
            List<Integer> win = winningLotto.getNumbers();
            List<Integer> lotto1 = lotto.getNumbers();
            Integer matchingCount = getMatchingCount(win, lotto1);
            Rank rank = findIndex(matchingCount);
            if(rank ==null) continue;
            if(rank.equals(Rank.THIRD) && lotto1.contains(bonusNumber.getBonus())) rank = Rank.SECOND;
            saveResult(rank);
        }
        return result;
    }

    private void initializePrize(){
        result.put(Rank.FIFTH, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);
    }

    private Integer getMatchingCount(List<Integer> win, List<Integer> lotto1) {
        List<Integer> intersection = new ArrayList<>(win);
        intersection.retainAll(lotto1);
        return intersection.size();
    }

    private Rank findIndex(Integer matchingCount){
        if(Objects.equals(matchingCount, Rank.FIFTH.getCount())) return Rank.FIFTH;
        if(Objects.equals(matchingCount, Rank.FOURTH.getCount())) return Rank.FOURTH;
        if(Objects.equals(matchingCount, Rank.THIRD.getCount())) return Rank.THIRD;
        if(Objects.equals(matchingCount, Rank.FIRST.getCount())) return Rank.FIRST;
        return null;
    }

    private void saveResult(Rank rank){
        result.replace(rank, result.get(rank)+1);
    }

    public double calculateFinalResult(){
        long totalPrize = calculateTotalPrize(result);
        return calculateProfitRate(totalPrize, purchaseQuantity.getPurchaseQuantity());
    }

    private static long calculateTotalPrize(Map<Rank, Integer> result) {
        return (long) result.entrySet().stream()
                .mapToDouble(entry -> Rank.convertPrize(entry.getKey()) * entry.getValue())
                .sum();
    }

    private static double calculateProfitRate(long totalPrize, Integer purchaseQuantity) {
        return ((double) totalPrize / (purchaseQuantity * Constants.DIVISOR.getConstant())) * 100;
    }
}
