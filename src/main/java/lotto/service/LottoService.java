package lotto.service;

import lotto.model.Lotto;
import lotto.model.UserData;
import lotto.view.UserInput;
import lotto.view.PrintMessages;

//import lotto.common.utils.ValidationUtils;


//단일 데이터에 대한 데이터 처리
public class LottoService {

    UserData userData = new UserData();
    Lotto[] lotto;

    UserInput userInput = new UserInput();

    public void userInput() {

        PrintMessages.printInputMoneyMsg();
        userInput.getInput();

        userData.setLottoPapes( userData.getMoney() );

        lotto = new Lotto[ userData.getLottoPapes() ];


    }


}
