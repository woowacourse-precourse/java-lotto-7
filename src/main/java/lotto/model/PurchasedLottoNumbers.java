package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class PurchasedLottoNumbers {
    private final ArrayList<List<Integer>> purchasedLottoNumbers;
    public PurchasedLottoNumbers(){
        this.purchasedLottoNumbers = new ArrayList<>();
    }
    public void makePurchasedLottoNumbers(List<Integer> purchasedLottoNumber){
        purchasedLottoNumbers.add(purchasedLottoNumber);
    }
    public ArrayList<List<Integer>> getPurchasedLottoNumbers(){
        return purchasedLottoNumbers;
    }
}
