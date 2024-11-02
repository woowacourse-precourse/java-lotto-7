package lotto;

import java.util.Set;

public class Application {

    static int PurchaseAmount;
    static Set<Integer> LottoWinningNumbers;
    static int bonusNumber;

    static Input input=new Input();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            try {
                inputData();
                break;
            } catch (NumberFormatException e) {
                System.err.println(("[ERROR] 당첨번호 입력은 숫자만 입력할수있습니다."));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());

            }
        }
    }

    public static void inputData() {

        input.setPurchaseAmount();
        PurchaseAmount = input.getPurchaseAmount();

    }


}
