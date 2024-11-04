package lotto.dto;

public class PurchaseRequest {
    private String price;

    public PurchaseRequest(String price){
        this.price = price;
    }

    public String getPrice(){
        return price;
    }
}
