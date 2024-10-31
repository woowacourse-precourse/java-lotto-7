package lotto.buyer.validator;

import lotto.buyer.infrastructure.Won;
import lotto.constant.ErrorMessage;
import lotto.util.ValidationProcess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {
    @Test
    @DisplayName("1000원으로 안나눠지는 경우 예외 발생")
    void divisibleByThousand() {
        List<String> exceptionData = List.of("12313", "1323", "1001", "10", "1");
        ValidationProcess.createThrownBy(exceptionData, Won::of, ErrorMessage.DIVISIBLE_BY_THOUSAND);
    }

    @Test
    @DisplayName("10만원 초과일 경우 예외 발생")
    void validateAmountUnderLimit() {
        List<String> exceptionData = List.of("12313123", "213213", "100001", "123132123");
        ValidationProcess.createThrownBy(exceptionData, Won::of, ErrorMessage.AMOUNT_LIMIT);
    }

    @Test
    @DisplayName("Money 생성시 10만원 초과일 경우 예외 발생")
    void createMoneyTest() {
        List<String> exceptionData = List.of("9223372036854775808", "922337203685477580123", "23154192233720368");
        ValidationProcess.createThrownBy(exceptionData, Won::of, ErrorMessage.AMOUNT_LIMIT);
    }

}
