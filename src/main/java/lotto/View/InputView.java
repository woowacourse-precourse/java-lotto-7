package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int priceInput(){
        while(true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();
                int price = Integer.parseInt(input);

                if (price <= 0 || price % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1000단위이어야 합니다.");
                }
                return price;
            }
            catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
            catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}
