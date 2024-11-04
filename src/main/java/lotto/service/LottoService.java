package lotto.service;

import java.util.List;
import java.util.Scanner;
import lotto.global.exception.Messages;

public class LottoService {
    private static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    // 구입 금액 입력받기
    public Integer inputPrice(){

        Scanner scanner = new Scanner(System.in);
        Integer price = 0;

        while (price!=0 && price%1000==0){
            System.out.println(GET_PRICE_MESSAGE);
            price = scanner.nextInt();

            if(price%1000!=0){
                throw new IllegalArgumentException(Messages.DEFAULT_ERROR + Messages.PRICE_ERROR);
            }
        }

        return price;
    }
}
