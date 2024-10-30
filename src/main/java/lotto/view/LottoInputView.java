package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoInputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getMoneyInput(){
        Integer moneyInput = 0;

        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            moneyInput = Integer.parseInt(Console.readLine().trim());
        } catch (NoSuchElementException e) {
            System.out.println("input error");
            throw new IllegalArgumentException();
        }

        return moneyInput;
    }

    public List<Integer> getNumbersInput(){
        List<Integer> numbersInput = new ArrayList<>();
        try{
            System.out.println(INPUT_NUMBERS_MESSAGE);
            String temp = Console.readLine().trim();
            Arrays.stream(temp.split(",")).map(Integer::parseInt).forEach(numbersInput::add);
        } catch (NoSuchElementException e) {
            System.out.println("input error");
            throw new IllegalArgumentException();
        }

        return numbersInput;
    }

    public Integer getBonusNumberInput(){
        Integer bonusNumberInput = 0;
        try{
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            bonusNumberInput = Integer.parseInt(Console.readLine().trim());
        } catch (NoSuchElementException e) {
            System.out.println("input error");
            throw new IllegalArgumentException();
        }

        return bonusNumberInput;
    }
}
