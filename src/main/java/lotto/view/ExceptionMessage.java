package lotto.view;

public class ExceptionMessage {

    private static final String NOT_NUMBER = "[ERROR] 금액은 숫자만 입력해야 합니다!";
    private static final String NOT_THOUSAND_UNIT = "[ERROR] 구매 금액은 1000원 단위 입니다!";
    private static final String PRICE_MUST_BE_POSITIVE = "[ERROR] 구매 금액은 0원을 초과해야 합니다!";


    public static void priceNumberException(){
        System.out.println(NOT_NUMBER);
    }

    public static void priceMustBePositiveException(){
        System.out.println(PRICE_MUST_BE_POSITIVE);
    }

    public static void priceUnitException(){
        System.out.println(NOT_THOUSAND_UNIT);
    }



}
