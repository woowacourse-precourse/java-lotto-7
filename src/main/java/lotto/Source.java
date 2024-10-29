package lotto;

public class Source {

    public static int inputAmountOrBonusNumber(String amount){
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    public static String[] inputWinningNumber(String winningNumber){
        return winningNumber.split(",");
    }
}
