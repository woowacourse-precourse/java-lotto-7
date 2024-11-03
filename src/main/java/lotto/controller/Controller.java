package lotto.controller;

import lotto.Service.ValidService;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    ValidService validService=new ValidService();


    public void start(){
        Output.requestPurchaseAmount();
        while (true){
            String money= Input.getInput();
            try{
                validService.validMoney(money);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }





    }

}
