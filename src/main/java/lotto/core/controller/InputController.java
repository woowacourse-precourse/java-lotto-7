package lotto.core.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import lotto.core.domain.model.Money;
import lotto.core.view.OutputView;
import lotto.system.input.InputTask;
import lotto.system.message.Message;


public class InputController {
    private final OutputView outputView;
    private final Queue<Message> inputMessageQueue;

    public InputController(OutputView outputView, Queue<Message> inputMessageQueue) {
        this.outputView = outputView;
        this.inputMessageQueue = inputMessageQueue;
    }

    private String readUserInput() {
        return Console.readLine();
    }

//    public String readUserInput() {
//        InputTask.userInput();
//        while(true) {
//            Message message = inputMessageQueue.poll();
//            if(message!=null) return message.getContent();
//        }
//
//    }

    public Integer getMoney() {
        String given = readUserInput();
        try {
            int givenMoney = checkNumber(given);
            Money.checkMoney(givenMoney);
            return givenMoney;
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return getMoney();
        }
    }

    public List<Integer> getLottoNumber() {
        String given = readUserInput();
        try {
            List<Integer> arr = Arrays.stream(given.split(",")).map(this::checkNumber).toList();
            lottoNumberRangeCheck(arr);
            return arr;
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return getLottoNumber();
        }
    }

    public Integer getBonusNumber() {
        String given = readUserInput();
        try {
            Integer bonusNumber = checkNumber(given);
            lottoNumberRangeCheck(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return getBonusNumber();
        }
    }

    public Integer checkNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            throw new IllegalArgumentException();
        }
    }

    public void lottoNumberRangeCheck(List<Integer> arr) {
        for (Integer item : arr) {
            lottoNumberRangeCheck(item);
        }
    }

    public void lottoNumberRangeCheck(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
