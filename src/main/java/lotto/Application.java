package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price=0;
        while(price<=0) {
            System.out.println("구입 금액을 입력해주세요.");
            String priceInput = Console.readLine();

            try {
                price=getPrice(priceInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        //가격 정상 입력 테스트용
        System.out.println("price: "+price);


    }

    public static int getPrice(String priceInput) throws IllegalArgumentException{
        int price=0;
        String ERRORMESSAGE="[ERROR] 가격은 양의 정수여야 합니다.";

        try{
            price=Integer.parseInt(priceInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERRORMESSAGE);
        }

        if(price<=0 || price%1000!=0) {
            throw new IllegalArgumentException(ERRORMESSAGE);
        }


        return price;
    }
}
