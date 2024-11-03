package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewInput {
    public static final String INITIAL_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_AMOUNT_COUNT_MESSAGE = "%d개를 구매했습니다.%n";
    public static final String RECEIVE_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";
    public static final String RECEIVE_LUCKY_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String INPUT_NEGATIVE_VALUE_ERROR_MESSAGE = "[ERROR] 구입 금액은 음수가 될 수 없습니다.";
    public static final String ILLEGAL_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 입력 형식이 잘못되었습니다.: ";
    public static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6개 이어야 합니다.";
    public static final String WINNING_NUMBER_VALUE_ERROR = "[ERROR] 당첨 번호는 1~45사이의 숫자이어야 합니다.";
    public static final String LUCK_NUMBER_VALUE_ERROR = "[ERROR] 행운의 순자는 1~45사이의 숫자이어야 합니다.";
    public static final String WINNING_NUMBER_DUPLICATE_ERROR ="[ERROR] 당첨 번호는 중복된 값이 올 수 없습니다.";

    public static List<Integer> winningNumberList = new ArrayList<>();

    public int receivePurchaseAmount(){
        while(true) {
            try {
                System.out.println(INITIAL_MESSAGE);
                String purchaseAmount = Console.readLine();
                validatorPurchaseAmount(Integer.parseInt(purchaseAmount));
                printPurchaseAmount(Integer.parseInt(purchaseAmount));
                return Integer.parseInt(purchaseAmount) / 1000;
            }catch(NumberFormatException | IllegalStateException e) { System.out.println(ILLEGAL_NUMBER_FORMAT_ERROR_MESSAGE + e.getMessage()); }
        }
    }

    public List<Integer> receiveWinningNumber(){
        while(true){
            try{
                System.out.println(RECEIVE_WINNING_NUMBER_MESSAGE);
                String winningNumber = Console.readLine();
                String[] winningNumberArray = winningNumber.split(",");
                winningNumberList.clear();
                for (String s : winningNumberArray) { winningNumberList.add(Integer.parseInt(s.trim()));}
                validatorWinningNumber(winningNumberList);
                return winningNumberList;
            }catch(NumberFormatException | IllegalStateException e) { System.out.println(ILLEGAL_NUMBER_FORMAT_ERROR_MESSAGE + e.getMessage());;}
        }
    }

    public int receiveLuckyNumber(){
        while(true){
            try{
                System.out.println(RECEIVE_LUCKY_NUMBER_MESSAGE);
                String luckyNumber = Console.readLine();
                validatorLuckyNumber(Integer.parseInt(luckyNumber),winningNumberList);
                return Integer.parseInt(luckyNumber.trim());
            }catch(NumberFormatException | IllegalStateException e) { System.out.println(ILLEGAL_NUMBER_FORMAT_ERROR_MESSAGE + e.getMessage()); }
        }

    }

    private void printPurchaseAmount(int purchaseAmount){
        int purchaseAmountCount = purchaseAmount / 1000;
        System.out.printf(PURCHASE_AMOUNT_COUNT_MESSAGE, purchaseAmountCount);
    }

    private void validatorPurchaseAmount(int purchaseAmount){
        if(purchaseAmount < 0){
            throw new IllegalArgumentException(INPUT_NEGATIVE_VALUE_ERROR_MESSAGE);
        }
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void validatorWinningNumber(List<Integer> winningNumberList){
        if(winningNumberList.size() != 6){
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }
        for(Integer number : winningNumberList){
            if(number < 0 || number > 45){
                throw new IllegalArgumentException(WINNING_NUMBER_VALUE_ERROR);
            }
        }
    }


    private void validatorLuckyNumber(int luckyNumber, List<Integer> winningNumberList){
        if(luckyNumber < 0 || luckyNumber > 45){
            throw new IllegalArgumentException(LUCK_NUMBER_VALUE_ERROR);
        }
        List<Integer> winningNumberListCheck = winningNumberList;
        for(Integer number : winningNumberListCheck){
            if(luckyNumber == number || hasDuplicate(winningNumberList)){
                throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
            }
        }
    }

    private boolean hasDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() != list.size();
    }

}
