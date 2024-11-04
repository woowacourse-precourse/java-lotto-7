package lotto;

import java.util.List;

public class Buyer {
    final private int purchaseAmount;
    private List<Lotto> purchaseLotto;
    private int revenue;

    final private String ERROR_MASSAGE = "[ERROR] 잘못된 금액 입력";
    public Buyer(String amount) {
        validateAmount(amount);
        this.purchaseAmount = Integer.parseInt(amount);
    }
    public void getRateOfReturn(){
        double profitRate = ((double) (this.revenue - this.purchaseAmount) / this.purchaseAmount) * 100;
        System.out.println("총 수익률은 " + (double)(100.0 + Math.round(profitRate * 100) / 100.0) + "%입니다.");
    }
    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    private void validateAmount(String amount) {
        int value;
        try {
            value = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MASSAGE);
        }

        if(value % 1000 != 0) throw new IllegalArgumentException(ERROR_MASSAGE);
    }

    public void setPurchaseLotto(List<Lotto> lottos){
        this.purchaseLotto = lottos;
    }
    public int getPurchaseAmount(){
        return this.purchaseAmount;
    }

    public List<Lotto> getPurchaseLotto(){
        return this.purchaseLotto;
    }
}
