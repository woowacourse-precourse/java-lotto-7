package lotto.model;

import lotto.constant.ErrorMessage;

public class LottoManager {

    private PurchaseQuantity purchaseQuantity; //구매 수량

    private Lotto winnigLotto; //당첨 로또

    private BonusNumber bonusNumber;

    public LottoManager(){}

    public void setPurchaseQuantity(PurchaseQuantity purchaseQuantity){
        this.purchaseQuantity = purchaseQuantity;
    }

    public void setWinningLotto(Lotto winnigLotto){
        this.winnigLotto = winnigLotto;
    }

    public void setBonusNumber(BonusNumber bonusNumber){
        validateBonus(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonus(BonusNumber bonusNumber){
        if(winnigLotto.getNumbers().contains(bonusNumber.getBonus())) throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WINNING_NUM.getMessage());
    }

}
