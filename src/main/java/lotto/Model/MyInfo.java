package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class MyInfo {

    private Integer purchasePrice;
    private Integer lottoCount;
    private List<Lotto> myLottos;
    private Lotto answerLotto;
    private Integer bonusNumber;
    private Integer revenue;
    private Double myReturn;

    public MyInfo() {
        this.purchasePrice = 0;
        this.lottoCount = 0;
        this.myLottos = new ArrayList<>();
        this.answerLotto = null;
        this.bonusNumber = 0;
        this.revenue = 0;
        this.myReturn = 0.0;
    }

    public Integer getLottoCount() {
        return this.lottoCount;
    }

    public List<Lotto> getMyLottos() {
        return this.myLottos;
    }

    public Integer getPurchasePrice() {
        return this.purchasePrice;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public Lotto getAnswerLotto() {
        return this.answerLotto;
    }

    public Integer getRevenue() {
        return this.revenue;
    }

    public Double getMyReturn() {
        return this.myReturn;
    }

    public void setMyLottos(List<Lotto> myLottos) {
        this.myLottos = myLottos;
    }

    public void setAnswerLotto(Lotto answerLotto) {
        this.answerLotto = answerLotto;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setLottoCount(Integer lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void setMyReturn(Double myReturn) {
        this.myReturn = myReturn;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }
}
