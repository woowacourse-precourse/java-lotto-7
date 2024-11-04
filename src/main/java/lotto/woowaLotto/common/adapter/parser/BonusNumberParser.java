package lotto.woowaLotto.common.adapter.parser;

public class BonusNumberParser {

    public Integer parse(String input) {
        try{
            int bonusNum = Integer.parseInt(input);
            valid(bonusNum);
            return bonusNum;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    private void valid(int bonusNum){
        if(bonusNum < 1 || bonusNum > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
