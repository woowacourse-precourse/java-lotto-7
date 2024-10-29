package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public int divideByThousand(String input) {
        try{
            isNumeric(input);
            checkAmountWithinRange(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("다시 입력해 주세요.");
            divideByThousand(Console.readLine());
        }
        return Integer.parseInt(input) / 1000;
    }

    public void isNumeric(String input){
        if(!input.matches("[0-9]+$")){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }
    public void checkAmountWithinRange(String input){
        if (Integer.parseInt(input) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }
    }
    public String requestPurchaseAmountInput(){
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }



    public static void main(String[] args) {
        Application application = new Application();
        application.divideByThousand(application.requestPurchaseAmountInput());
    }
}
