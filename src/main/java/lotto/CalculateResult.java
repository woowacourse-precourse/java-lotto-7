package lotto;

import java.util.HashMap;

public class CalculateResult {
    public float Calculate(HashMap<Integer, Integer> result, Money money){
        int calculateRewords = 0;
        for(int rewords:result.keySet()){
            calculateRewords += result.get(rewords) * rewords;
        }
        return ((float) calculateRewords / money.getMoneyValue());
    }
}
