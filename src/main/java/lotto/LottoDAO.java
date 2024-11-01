package lotto;


import java.util.ArrayList;

public class LottoDAO {
        private ArrayList<Lotto> LottoDatabase = new ArrayList<>();
        private int cost;
        private int purchaseRound;
        private Lotto lottoSelect;
        private int bonusNumber;


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

    public int getPurchaseRound() {
        return purchaseRound;
    }

    public void setPurchaseRound(int purchaseRound) {
        this.purchaseRound = purchaseRound;
    }

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
}
