package lotto.service;

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

    public int getNumberOfTickets(String inputPayment) {
        int payment = Integer.parseInt(inputPayment);
        return payment / 1_000;
    }

}
