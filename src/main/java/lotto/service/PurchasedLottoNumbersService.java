package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.PurchasedLottoNumbers;
import lotto.model.RandomNumbers;

public class PurchasedLottoNumbersService {
    private PurchasedLottoNumbers purchasedLottoNumbers;

    public PurchasedLottoNumbersService(){
    }

    public void PurchasedLottoNumbersGenerator(int times){
        this.purchasedLottoNumbers = new PurchasedLottoNumbers(RandomNumbers.generateSortedRandomLottoSets(times));
    }

    public ArrayList<List<Integer>> getPurchasedLottoNumbers(){
        return purchasedLottoNumbers.getPurchasedLottoNumbers();
    }
}
