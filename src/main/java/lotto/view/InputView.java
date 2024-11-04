package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.validator.NumberValidate;

public class InputView {
    public static int getAmount(){
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = readLine();

                NumberValidate.validateAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
