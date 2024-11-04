package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


//view-> 로또 번호입력 받고, 당첨된 결과 출력
//생성된 로또 번호 출력 및 당첨 결과 출력
public class InputView {
    private static final String Input_Lotto_Money="구입 금액을 입력해 주세요.";
    private static final String Input_Lotto_Winning="당첨 번호를 입력해 주세요.";
    private static final String Input_Bonus_Number="보너스 번호를 입력해주세요.";
    private static final String INPUT_TYPE_ERROR="[ERROR] 숫자만 입력해 주세요";
    //    private static final String Input_validate_Number="[ERROR] 유효하지 않은 숫자 입력입니다. 숫자만 입력해주세요.";
//    private static final String Input_Not_valid="유효하지 않은 숫자 입력입니다.";
//    private static final String Error="[ERROR]";

    private static List<Integer> winningNumberList;

    public static String inputPlayerMoney(){
        System.out.println(Input_Lotto_Money);
        return Console.readLine();
    }

    public static List<Integer> inputWinningNumber(){
        System.out.println(Input_Lotto_Winning);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber(){
        System.out.println(Input_Bonus_Number);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String winningNumber){
        String [] result= winningNumber.split(",");
        winningNumberList= new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(convertToInt(result[i]));
        }
        return winningNumberList;
    }
    private static int convertToInt(String inputNumber) {
        if (!inputNumber.matches("\\d+")) { // 숫자가 아닌 경우
            ExceptionMessage.typeException(); // [ERROR] 숫자만 입력해 주세요.
            throw new IllegalArgumentException(INPUT_TYPE_ERROR);
        }
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }


}
