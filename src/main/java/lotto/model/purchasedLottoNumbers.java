package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class purchasedLottoNumbers {
    private final ArrayList<List<Integer>> purchasedLottoNumbers;
    public purchasedLottoNumbers(ArrayList<List<Integer>> purchasedLottoNumbers){
        this.purchasedLottoNumbers = purchasedLottoNumbers;
    }
    public ArrayList<List<Integer>> getPurchasedLottoNumbers(){
        return purchasedLottoNumbers;
    }
}
