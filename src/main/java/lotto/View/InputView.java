package lotto.View;


import static lotto.Model.ErrorCode.PARSING_INTEGER_ERROR;
import static lotto.Model.ErrorCode.RETRY_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Validation;

public class InputView {

    private final static Validation validation = new Validation();


    //사용자에게 구입금액 입력받는 메소드
    public int inputPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요");
        while (true){
            try{
                int purchasePrice=Integer.parseInt(Console.readLine());
                validation.purchaseValidator(purchasePrice);
                return purchasePrice;
            }catch (NumberFormatException e){
                System.out.println(PARSING_INTEGER_ERROR.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
        }

    }

    //사용자에게 당첨번호 받는 로직
    public String[] setWinningNumber() {
        System.out.println("당첨 번호를 쉼표로 구분해 입력해 주세요 당첨번호는 1~45까지 6자리 수 입니다");
        while (true){
            try{
                String[] winningNumber=Console.readLine().split(",");
                validation.winningNumberValidator(winningNumber);
                return winningNumber;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
        }
    }


    //사용자에게 보너스 번호 받는 로직
    public int setBonusNumber() {
        System.out.println("보너스숫자를 입력해 주세요");
        while (true){
            try{
                int bonusNumber=Integer.parseInt(Console.readLine());
                validation.bonusNumberValidator(bonusNumber);
                return bonusNumber;
            }catch(NumberFormatException e){
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println(RETRY_MESSAGE.getMessage());
            }
        }

    }
}
