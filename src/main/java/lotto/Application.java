package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해주세요.");
        String value;
        while(true){
            value = Console.readLine();
            try {
                if (validateAmount(value)) break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR]");
            }
        }

        Buyer buyer = new Buyer(value);
        buyer.setPurchaseLotto(store.salesLotto(buyer.getPurchaseAmount()));
        store.setWinningNumbers();
        store.setBonusNumber();
        buyer.setRevenue(store.rankAndRevenue(buyer.getPurchaseLotto()));
        buyer.getRateOfReturn();
    }

    static private boolean validateAmount(String amount) {
        int value;
        try {
            value = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액 입력");
        }

        if(value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 잘못된 금액 입력");

        return true;
    }
}