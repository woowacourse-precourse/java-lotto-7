package lotto.model;

import java.util.HashMap;
import lotto.domain.Money;

public class CalculateResult {
    public float Calculate(HashMap<Integer, Integer> result, Money money){
        int calculateRewords = 0;
        for(int rewords:result.keySet()){
            calculateRewords += result.get(rewords) * rewords;
        }
        return ((float) calculateRewords / money.getMoneyValue());
    }
}
