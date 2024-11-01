package lotto.service;

import lotto.common.utils.ValidationUtils;
import lotto.model.Lotto;
import lotto.model.UserData;
import lotto.view.UserInput;
import lotto.view.PrintMessages;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class LottoService{

    UserData userData = new UserData();
    UserInput userInput = new UserInput();
    InputParser inputParser = new InputParser();
    MatchCheck matchCheck = new MatchCheck();
    Lotto[] lotto;

    public void userInput() {
        int integerData;
        List<Integer> arrayData;

        //Money Input
        PrintMessages.printInputMoneyMsg();
        integerData = inputParser.strToInt( userInput.getInput() );
        userData.setMoney(integerData);

        //Calculate Lotto Papers
        integerData = inputParser.calculatePapers( integerData );
        userData.setLottoPapes(integerData);
        PrintMessages.printBuyMsg(integerData);

        //WinNumber Input
        PrintMessages.printInputWinNumberMsg();
        arrayData = inputParser.splitToArray( userInput.getInput() );
        userData.setWinNumbers(arrayData);

        //BonusNumber Input
        PrintMessages.printInputBonusNumberMsg();
        integerData = inputParser.strToInt( userInput.getInput() );
        ValidationUtils.validateDuplicateBonusNumber(arrayData, integerData);
        userData.setBonusNumber(integerData);

    }

    public void lotResult() {
        int matchCount = 0;
        List<Integer> matchs;
        PrintMessages.printResultMsg();
        PrintMessages.printDash();
        createPapers();  // `createPapes` 메서드로 로또 용지 생성

        matchs = matchCheck.matchCountPapers(lotto, userData.getWinNumbers(), userData.getBonusNumber());
        System.out.println(matchs);

    }


    public void createPapers(){
        lotto = new Lotto[ userData.getLottoPapes() ];
        for ( int i = 0; i < lotto.length; i++ ) {
            lotto[i] = new Lotto( inputParser.sortArray(createRandomNumber()) );
        }
    }

    public List<Integer> createRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }



}
