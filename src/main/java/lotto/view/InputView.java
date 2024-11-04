package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.InputController;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    //Lotto lotto = new Lotto(); // Lotto 객체 생성
    public static String purchaseAmount(){
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        return input;
        //return Lotto.parseInt(input); // String으로 받은 후 Lotto에서 변환
        //System.out.println();
       // return  Integer.parseInt(Console.readLine());
    }

    public static void printPurchaseQuantity(int price){
        int purchaseQuantity = price/1000;
        int remainPurchaseQuantity = price%1000;
        Lotto.validateUnit(remainPurchaseQuantity);
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
    }

    public static List<Integer> winningNumber(){
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = new ArrayList<>();
            winningNumbers = InputController.getWinningNumber();
            Lotto.validate(winningNumbers);
        return winningNumbers;
    }

    public static int bonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = InputController.getBonusNumber();
        System.out.println();
        return bonusNumber;
    }


}
