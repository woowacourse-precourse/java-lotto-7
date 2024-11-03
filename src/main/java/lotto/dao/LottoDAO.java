package lotto.dao;


import lotto.properties.LottoMatch;
import lotto.vo.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SimpleTimeZone;

public class LottoDAO {
        private ArrayList<Lotto> LottoDatabase = new ArrayList<>();
        private int cost;
        private int purchaseRound;
        private Lotto lottoSelect;
        private int bonusNumber;
        private HashMap<LottoMatch,Integer> lottoResult;
        private Double rateReturn;

    public ArrayList<Lotto> getLottoDatabase() {
        return LottoDatabase;
    }

    public void setLottoDatabase(ArrayList<Lotto> lottoDatabase) {
        LottoDatabase = lottoDatabase;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPurchaseRound() {
        return purchaseRound;
    }

    public void setPurchaseRound(int purchaseRound) {
        this.purchaseRound = purchaseRound;
    }

    public Lotto getLottoSelect() {
        return lottoSelect;
    }

    public void setLottoSelect(Lotto lottoSelect) {
        this.lottoSelect = lottoSelect;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public HashMap<LottoMatch, Integer> getLottoResult() {
        return lottoResult;
    }

    public void setLottoResult(HashMap<LottoMatch, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Double getRateReturn() {
        return rateReturn;
    }

    public void setRateReturn(Double rateReturn) {
        this.rateReturn = rateReturn;
    }
}
