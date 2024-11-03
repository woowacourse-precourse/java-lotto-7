package lotto.DTO;

public class PaymentPriceDTO {
    private Integer paymentPrice;

    public PaymentPriceDTO(String paymentPrice) {
        this.paymentPrice = Integer.parseInt(paymentPrice);
    }

    public Integer getPaymentPrice() {
        return paymentPrice;
    }
}
