package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public int getPrice() {
        while (true) {
            try {
                int price = receivePayment();
                validPrice(price);
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

    public void validPrice(int price) throws IllegalArgumentException {
        if (price % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_UNIT.toString());
    }

    public Lotto getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = receiveWinningNumbers();
                List<Integer> winningNumberList = parseWinningNumbers(winningNumbers);
                return new Lotto(winningNumberList);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 당첨번호를 입력하세요.");
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
        for (String winNumber : winNumberArray) {
            winNumberList.add(Integer.parseInt(winNumber.trim()));
        }
        return winNumberList;
    }

    public int getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = receiveBonusNumber();
                if (!winningLotto.getNumberString().contains(bonusNumber)) {
                    return Integer.parseInt(bonusNumber);
                }
                System.out.println(ErrorMessage.INVALID_BONUS);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT);
            }
        }
    }

    public String receiveBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }
}
