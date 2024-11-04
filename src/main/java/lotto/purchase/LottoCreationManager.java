package lotto.purchase;

import java.util.List;

public class LottoCreationManager {

    public static final int LOTTO_PRICE = 1000;

    private final PurchaseInput purchaseInput = new PurchaseInput();
    private final PaymentExtractor paymentExtractor = new PaymentExtractor();
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public LottoReceipt process() {
        int payment = receivePayment();
        return new LottoReceipt(payment, makeLotteries(payment));
    }

    private int receivePayment() {
        try {
            String rawPayment = purchaseInput.getMoney();
            return paymentExtractor.extract(rawPayment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receivePayment();
        }
    }

    private List<MyLotto> makeLotteries(int payment) {
        return lottoGenerator.createLotteries(payment / LOTTO_PRICE);
    }
}
