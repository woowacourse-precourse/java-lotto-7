package lotto.validator;

public class InputValidator {

    public static boolean validateLottoMoney(int lottoMoney) {
        if (lottoMoney <= 0) {
            System.out.println("[ERROR] 로또 가격은 양의 정수여야 합니다.");
            return false;
        }
        if (lottoMoney % 1000 != 0) {
            System.out.println("[ERROR] 로또 가격은 1,000원으로 나누어 떨어져야 합니다.");
            return false;
        }
        return true;

    }

    public static boolean validateInputInteger(String input) {
        if (!input.matches("\\d+")) {
            System.out.println("[ERROR] 로또 가격은 숫자여야 합니다.");
            return false;
        }
        return true;
    }


}
