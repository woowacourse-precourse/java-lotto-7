package lotto.view;

public class ExceptionMessage {

    private static final String NOT_NUMBER = "[ERROR] 숫자만 입력해야 합니다!(로또 번호 입력의 경우 구분자는 쉼표)";
    private static final String NOT_THOUSAND_UNIT = "[ERROR] 구매 금액은 1000원 단위 입니다!";
    private static final String PRICE_MUST_BE_POSITIVE = "[ERROR] 구매 금액은 0원을 초과해야 합니다!";

    private static final String NOT_DUPLICATE_LOTTO_NUMBERS = "[ERROR] 로또의 번호는 중복되면 안됩니다!";
    private static final String OUT_OF_RANGE_LOTTO_NUMBERS = "[ERROR] 로또의 번호는 1~45 사이의 정수입니다!";

    private static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 로또번호와 중복되면 안됩니다!";

    public static void priceNumberException(){
        System.out.println(NOT_NUMBER);
    }

    public static void priceMustBePositiveException(){
        System.out.println(PRICE_MUST_BE_POSITIVE);
    }

    public static void priceUnitException(){
        System.out.println(NOT_THOUSAND_UNIT);
    }

    public static void duplicateLottoNumberException(){
        System.out.println(NOT_DUPLICATE_LOTTO_NUMBERS);
    }

    public static void outOfRangeException(){
        System.out.println(OUT_OF_RANGE_LOTTO_NUMBERS);
    }

    public static void bonusNumberException(){
        System.out.println(INVALID_BONUS_NUMBER);
    }
}
