package lotto.dto;

public class LottoPurchasesDto {

    private int numberOfPurchase;
    private String purchasesMessage;

    public LottoPurchasesDto(int numberOfPurchase, String purchasesMessage) {
        this.numberOfPurchase = numberOfPurchase;
        this.purchasesMessage = purchasesMessage;
    }

    public int getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public void setNumberOfPurchase(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
    }

    public String getPurchasesMessage() {
        return purchasesMessage;
    }

    public void setPurchasesMessage(String purchasesMessage) {
        this.purchasesMessage = purchasesMessage;
    }
}
