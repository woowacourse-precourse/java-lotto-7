package lotto.view;

import java.util.Scanner;

public class InputView{
    Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = scanner.nextLine();
                int purchasePrice = Integer.parseInt(input);
                return purchasePrice;
            } catch (NumberFormatException e) {
                System.out.println("\n[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            }
        }
    }

    public String inputWinningNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public Integer inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
