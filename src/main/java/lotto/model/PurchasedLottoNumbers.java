package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottoNumbers {
    private final ArrayList<List<Integer>> purchasedLottoNumbers;
    public PurchasedLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers){
        this.purchasedLottoNumbers = purchasedLottoNumbers;
    }

    public ArrayList<List<Integer>> getPurchasedLottoNumbers(){
        return purchasedLottoNumbers;
    }
}
