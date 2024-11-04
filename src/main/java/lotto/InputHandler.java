package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputHandler {

    public int getPrice() {
        while (true) {
            try {
                int price = receivePayment();
                checkValidPrice(price);
                return price;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int receivePayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine().trim();
        return Integer.parseInt(inputPrice);
    }

    public void checkValidPrice(int price) throws IllegalArgumentException {
        if (price % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.toString());
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = receiveWinningNumbers();
                List<Integer> winningNumberList = parseWinningNumbers(winningNumbers);
                return winningNumberList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String receiveWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public List<Integer> parseWinningNumbers(String winningNumbers) throws IllegalArgumentException {
        List<Integer> winNumberList = new ArrayList<>();
        String[] winNumberArray = winningNumbers.trim().split(",");
        checkDuplication(winNumberArray);
        for (String winNumber : winNumberArray) {
            int singleWinNumber = Integer.parseInt(winNumber.trim());
            checkValidRange(singleWinNumber);
            winNumberList.add(singleWinNumber);
        }
        return winNumberList;
    }

    public void checkValidRange(int inputNumber) throws IllegalArgumentException {
        if (inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.toString());
        }
    }

    public void checkDuplication(String[] winNumberArray) throws IllegalArgumentException {
        HashSet<Integer> duplicationCheck = new HashSet<>();
        for (String winNumber : winNumberArray) {
            int number = Integer.parseInt(winNumber);
            if (!duplicationCheck.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.toString());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumberList) {
        while (true) {
            try {
                String inputBonusNumber = receiveBonusNumber();
                int bonusNumber = Integer.parseInt(inputBonusNumber);
                checkValidRange(bonusNumber);
                checkValidBonusNumber(winningNumberList, bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String receiveBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }

    public void checkValidBonusNumber(List<Integer> winningNumberList, int bonusNumber) throws IllegalArgumentException {
        if (winningNumberList.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS.toString());
        }
    }
}
