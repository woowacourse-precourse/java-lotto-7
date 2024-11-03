package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public void purchaseValidate(String purchaseValue){
            for(char c:purchaseValue.toCharArray()){
                if(!Character.isDigit(c)) throw new IllegalArgumentException("[ERROR] 입력값 오류");
            }
    }

    public void bonusNumValidate(List<Integer> bonusCheckList){
        Set<Integer> uniqueNumbers = new HashSet<>(bonusCheckList);
        if (uniqueNumbers.size() < bonusCheckList.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

}
