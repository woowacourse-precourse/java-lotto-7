package lotto.model;

public class PurchaseModel {
    private static PurchaseModel purchaseModel = new PurchaseModel();
    private static int ticketCount;

    private PurchaseModel() {}

    public int getTicketCount() {
        return ticketCount;
    }

    public static void setTicketCount(int ticketCount) {
        PurchaseModel.ticketCount = ticketCount;
    }
}
