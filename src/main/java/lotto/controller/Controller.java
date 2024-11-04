package lotto.controller;

import lotto.Service.ParsingService;
import lotto.Service.PublishLottoService;
import lotto.Service.ValidService;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;

public class Controller {
    private final ValidService validService = new ValidService();
    private final ParsingService parsingService = new ParsingService();
    private final User user1 = new User();
    private  WinningLotto winningLotto;


    public void start() {
        getMoney();
        buyLotto(parsingService.getMoney(),user1); //현재 문제상황
        displayLottos(user1);
        while (true){
            Output.requestWinningNumber();
            String winningNumbers=Input.getInput();
            try{
                validService.checkLottoNumbers(winningNumbers);
                break;
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());

            }
        }


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

    private void  buyLotto(int money,User user){
        int published_lotto_count=money/1000;
        for ( int count =1 ; count<=published_lotto_count;count++){
            Lotto lotto= PublishLottoService.publishLotto();
            user.addLotto(lotto);
        }
    }

    private void displayLottos(User user){
        Output.requestHowManyLottos(parsingService.getMoney());
        for(Lotto lotto:user.getLottos()){
            Output.requestLottoNumbers(lotto.getNumbers());
        }
    }




}
