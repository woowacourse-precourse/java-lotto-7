import domain.consumer.Consumer;
import domain.lotto.WoowahanLottoCompany;

public class Application {
    public static void main(String[] args) {
        WoowahanLottoCompany company = new WoowahanLottoCompany();
        Consumer consumer = new Consumer();
        company.enterForLottoPurchase(consumer);
        company.printLottoWinningResult(consumer);
    }
}
