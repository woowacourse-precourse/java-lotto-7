package lotto;

public class IO {

    public int inputBuyLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            int price = Integer.parseInt(input);

            if (price % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return price / 1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return inputBuyLottoPrice();
        }
    }
}
