package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private List<Integer> winningNumberList;
    public static String inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> winningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return numberList(Console.readLine());
    }

    public int bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> numberList(String winningNumber){
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for(int i=0;i< result.length;i++){
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    public int conventToInt(String inputNumber){
        try{
            return Integer.parseInt(inputNumber);
        }catch (NumberFormatException e){
            Exception.typeException();
            throw new IllegalArgumentException();
        }
    }
}
