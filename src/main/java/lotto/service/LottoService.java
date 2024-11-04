package lotto.service;

import lotto.model.Lotto;
import lotto.model.UserData;
import lotto.view.MatchLotto;
import lotto.view.UserInput;
import lotto.view.PrintMessages;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class LottoService{
    int integerData = 0;
    List<Integer> arrayData;

    UserData userData = new UserData();
    UserInput userInput = new UserInput();
    InputParser inputParser = new InputParser();
    MatchCheck matchCheck = new MatchCheck();
    Lotto[] lotto;

    public void moneyInput(){
        boolean isValid = false;

        PrintMessages.printInputMoneyMsg();

        while(!isValid){
            try {
                integerData = inputParser.strToInt(userInput.getInput());
                userData.setMoney(integerData);
                isValid = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void winNumberInput(){
        boolean isValid = false;

        PrintMessages.printInputWinNumberMsg();

        while(!isValid){
            try{
                arrayData = inputParser.splitToArray( userInput.getInput() );
                userData.setWinNumbers(arrayData);
                isValid = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void bonusNumberInput(){
        boolean isValid = false;

        PrintMessages.printInputBonusNumberMsg();

        while(!isValid){
            try{
                integerData = inputParser.strToInt( userInput.getInput() );
                userData.setBonusNumber(integerData);
                isValid = true;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void setPapers(){
        integerData = inputParser.calculatePapers( integerData );
        userData.setLottoPapers(integerData);
        PrintMessages.printBuyMsg(integerData);

        createPapers();
    }

    public void resultOutput() {
        double roi;
        HashMap<Lotto, MatchLotto> winPapers;
        List<Integer> count;

        userInput.closeInput();
        PrintMessages.printResultMsg();

        winPapers = matchCheck.winPapers(lotto, userData.getWinNumbers(), userData.getBonusNumber() );

        count = calculateMatchCountCounts(winPapers);
        roi = roiCalculator(winPapers);

        PrintMessages.printRoiMsg(count, roi);
    }

    private void createPapers() {
        lotto = new Lotto[userData.getLottoPapers()];

        for (int i = 0; i < lotto.length; i++) {
            List<Integer> randomNumbers = new ArrayList<>(createRandomNumber());
            lotto[i] = new Lotto(inputParser.sortArray(randomNumbers));
            PrintMessages.printCreatePaperMsg(lotto[i].getNumbers());
        }
    }

    private double roiCalculator(HashMap<Lotto, MatchLotto> winPapers) {
        int buyMoney = userData.getMoney();
        double roi = 0;
        double totalRevenue = winPapers.values()
                .stream()
                .mapToDouble(MatchLotto::getWinMoney)
                .sum();

        roi = (totalRevenue / (double)buyMoney) * 100;

        return Double.parseDouble(String.format("%.2f", roi));
    }

    private List<Integer> calculateMatchCountCounts(HashMap<Lotto, MatchLotto> winPapers) {
        List<Integer> matchCounts = new ArrayList<>(Collections.nCopies(MatchLotto.values().length, 0));

        winPapers.values().forEach(rank -> {
            int index = rank.ordinal();
            matchCounts.set(index, matchCounts.get(index) + 1);
        });

        return matchCounts;
    }

    private List<Integer> createRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
