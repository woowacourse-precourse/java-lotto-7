package lotto.week3.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {


    public static String purchaseAmountInput(){
        System.out.println("로또 구입 금액 1000원 단위로 입력 해주세요");
        return Console.readLine().trim();
    }

    public static List<Integer> winningNumberInput(){
        System.out.println("로또 당첨 번호 입력해주세요.");
        String[] winningNumber = Console.readLine().trim().split(",");
        List<Integer> answer = new ArrayList<>();
        for(String str : winningNumber){
            answer.add(Integer.parseInt(str));
        }
        return answer;
    }

     public static int bonusNumberInput(){
        System.out.println("보너스 번호 입력해주세요. ");
        return Integer.parseInt(Console.readLine().trim());
     }





}
