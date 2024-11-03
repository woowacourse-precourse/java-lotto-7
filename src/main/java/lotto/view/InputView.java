package lotto.view;

import java.util.Scanner;

public class InputView{
    Scanner scanner = new Scanner(System.in);

    public Integer inputPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
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
