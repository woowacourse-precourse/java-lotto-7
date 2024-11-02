package lotto.model;

import lotto.constant.Constants;
import lotto.constant.ErrorMessage;
import lotto.constant.Prize;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoManager {

    private PurchaseQuantity purchaseQuantity; //구매 수량

    private Lotto winningLotto; //당첨 로또

    private BonusNumber bonusNumber;

    private HashMap<Prize, Integer> result;

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
            Collections.sort(numbers);
            lottoList.add(new Lotto(numbers));
        }
        setLottos(lottoList);
        return lottos;
    }

    public void setLottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public HashMap<Prize, Integer> matchingLotto(){
        initializePrize();
        for(Lotto lotto: lottos){
            List<Integer> win = winningLotto.getNumbers();
            List<Integer> lotto1 = lotto.getNumbers();
            Integer matchingCount = getMatchingCount(win, lotto1);
            Prize prize = findIndex(matchingCount);
            if(prize==null) continue;
            if(prize.equals(Prize.FIVE) && lotto1.contains(bonusNumber.getBonus())) prize = Prize.FIVE_AND_BONUS;
            saveResult(prize);
        }
        return result;
    }

    private void initializePrize(){
        result.put(Prize.THREE, 0);
        result.put(Prize.FOUR, 0);
        result.put(Prize.FIVE, 0);
        result.put(Prize.FIVE_AND_BONUS, 0);
        result.put(Prize.SIX, 0);
    }

    private Integer getMatchingCount(List<Integer> win, List<Integer> lotto1) {
        List<Integer> intersection = new ArrayList<>(win);
        intersection.retainAll(lotto1);
        return intersection.size();
    }

    private Prize findIndex(Integer matchingCount){
        if(Objects.equals(matchingCount, Prize.THREE.getCount())) return Prize.THREE;
        if(Objects.equals(matchingCount, Prize.FOUR.getCount())) return Prize.FOUR;
        if(Objects.equals(matchingCount, Prize.FIVE.getCount())) return Prize.FIVE;
        if(Objects.equals(matchingCount, Prize.SIX.getCount())) return Prize.SIX;
        return null;
    }

    private void saveResult(Prize prize){
        result.replace(prize, result.get(prize)+1);
    }
}
