package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = 0;
        String winningNumbers = "";
        boolean moneyValid = true;
        boolean winningNumbersValid = true;
        while (moneyValid) {
            try {
                money = getValidMoney();
                moneyValid = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        LottoMachine lottoMachine = new LottoMachine(money);
        lottoMachine.makeLottos();
        lottoMachine.printLottos();
        while (winningNumbersValid){
            try{
                winningNumbers = Console.readLine();
                lottoMachine.inputWinnigNumbers(winningNumbers);
                winningNumbersValid = false;
            } catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }

        lottoMachine.inputBonusNumbers(Console.readLine());
        lottoMachine.initPrizeMap();
        lottoMachine.makePrizeMap();
        lottoMachine.printPrize();
        lottoMachine.printProfit();
    }

    private static int getValidMoney() {

        String input = Console.readLine();
        if (!isInt(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력 가능합니다.");
        }
        return amount;

    }

    private static boolean isInt(String input) {
        char tmp;
        for (int i = 0; i < input.length(); i++) {
            tmp = input.charAt(i);
            if (!Character.isDigit(tmp)) {
                return false;
            }
        }
        return true;
    }
}
