package lotto;

import java.util.Set;

public class Application {

    static int PurchaseAmount;
    static Set<Integer> LottoWinningNumbers;
    static int bonusNumber;

    static Input input=new Input();
    static RandomNumAllocation randomNumAllocation;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            try {
                inputPurchaseAmount();
                break;
            } catch (NumberFormatException e) {
                System.err.println(("[ERROR] 숫자만 입력할수있습니다."));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());

            }
        }
    }

    public static void inputPurchaseAmount() {

        //Console input
        input.setPurchaseAmount();
        PurchaseAmount = input.getPurchaseAmount();

    }


}
