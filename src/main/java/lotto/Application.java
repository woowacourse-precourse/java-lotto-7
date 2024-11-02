package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true){
            System.out.println("구입금액을 입력해 주세요.");
            String inputPrice = Console.readLine();
            try{
                Validation.validatePrice(inputPrice);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
