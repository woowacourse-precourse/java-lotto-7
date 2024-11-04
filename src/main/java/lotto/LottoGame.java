package lotto;

public class LottoGame {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        int amount;
        try {
            amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액 형식입니다.");
        }
        return amount;
    }
}
