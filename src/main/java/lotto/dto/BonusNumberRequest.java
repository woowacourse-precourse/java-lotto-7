package lotto.dto;

public class BonusNumberRequest {
    private String bonusNumber;

    public BonusNumberRequest(String bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public String getBonusNumber(){
        return bonusNumber;
    }
}
