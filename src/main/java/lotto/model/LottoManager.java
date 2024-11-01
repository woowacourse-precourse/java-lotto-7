package lotto.model;

import lotto.constant.Constants;
import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoManager {

    private PurchaseQuantity purchaseQuantity; //구매 수량

    private Lotto winnigLotto; //당첨 로또

    private BonusNumber bonusNumber;

    private final List<Lotto> lottos; //구매한 로또

    public LottoManager(){lottos = new ArrayList<>();}

    public void setPurchaseQuantity(PurchaseQuantity purchaseQuantity){
        this.purchaseQuantity = purchaseQuantity;
    }

    public PurchaseQuantity getPurchaseQuantity(){return this.purchaseQuantity;}

    public void setWinningLotto(Lotto winnigLotto){
        this.winnigLotto = winnigLotto;
    }

    public void setBonusNumber(BonusNumber bonusNumber){
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(BonusNumber bonusNumber){
        if(winnigLotto.getNumbers().contains(bonusNumber.getBonus())) throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WINNING_NUM.getMessage());
    }

    public List<Lotto> publishLotto(){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0;i< purchaseQuantity.getPurchaseQuantity(); i++){
            List<Integer> numbers = pickUniqueNumbersInRange(Constants.LOTTO_NUMBER_START_RANGE.getConstant(),
                    Constants.LOTTO_NUMBER_END_RANGE.getConstant(), Constants.LOTTO_SIZE.getConstant());
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}
