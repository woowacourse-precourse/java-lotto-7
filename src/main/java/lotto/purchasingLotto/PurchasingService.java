package lotto.purchasingLotto;

public class PurchasingService {
    private static PurchasingService purchasingService;

    private PurchasingService() {}

    public static PurchasingService getPurchasingService() {
        if(purchasingService == null) {
            purchasingService = new PurchasingService();
            return purchasingService;
        }
        return purchasingService;
    }

    public int purchaseTickets(String inputPayment) {
        int payment = Integer.parseInt(inputPayment);
        return payment / 1_000;
    }

}
