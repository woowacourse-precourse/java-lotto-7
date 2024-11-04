package lotto.service;

import java.util.Scanner;

public class LottoService {
    private static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    // 구입 금액 입력받기
    public Integer inputPrice(){
        System.out.println(GET_PRICE_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        Integer price = scanner.nextInt();

        return price;
    }
}
