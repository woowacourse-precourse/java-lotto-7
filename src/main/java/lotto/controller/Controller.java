package lotto.controller;

import lotto.Service.ParsingService;
import lotto.Service.ValidService;
import lotto.model.User;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    ValidService validService = new ValidService();
    ParsingService parsingService = new ParsingService();
    User user1 = new User();


    public void start() {
        getMoney();
        Output.requestHowManyLottos(parsingService.getMoney());
        buyLotto(parsingService.getMoney());
    }

    private void getMoney(){
        while (true) {
            String money = promptMoney();
            try {
                validMoney(money);
                parsingService.setMoney(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String promptMoney(){
        Output.requestPurchaseAmount();
        return Input.getInput();
    }

    private void validMoney(String money){
        validService.checkNull(money);
        validService.checkBig(money);
        validService.checkNum(money);
        validService.check1000s(money);
    }

    private void  buyLotto(int money){
        int published_lotto_count=money/1000;
        for ( int count =1 ; count<published_lotto_count;count++){

        }
    }



}
