package lotto.service;

public class PurchasingService {

    public int purchaseTickets(String inputPayment) {
        int payment = Integer.parseInt(inputPayment);
        return payment / 1_000;
    }

}
