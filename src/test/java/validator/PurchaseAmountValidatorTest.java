package validator;

import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator purchaseAmountValidator;

    @BeforeEach
    void setUp() {
        purchaseAmountValidator = new PurchaseAmountValidator();
    }

    @Test
    void 구입금액_비정상입력_테스트() {
        List<String> errorPurchaseAmountInputs = new ArrayList<>();

        errorPurchaseAmountInputs.add("a");
        errorPurchaseAmountInputs.add(",");
        errorPurchaseAmountInputs.add("1a4000");
        errorPurchaseAmountInputs.add("1 4 0 0 0");
        errorPurchaseAmountInputs.add("1 4000");
        errorPurchaseAmountInputs.add("+1 4000");
        errorPurchaseAmountInputs.add("100001");
        errorPurchaseAmountInputs.add("+100001");
        errorPurchaseAmountInputs.add("-1000");
        errorPurchaseAmountInputs.add("100000000");
        errorPurchaseAmountInputs.add("0.1");
        errorPurchaseAmountInputs.add("500");
        errorPurchaseAmountInputs.add("1500");
        errorPurchaseAmountInputs.forEach((purchaseAmountInput) -> {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            purchaseAmountValidator.validate(purchaseAmountInput))
                            .isInstanceOf(IllegalArgumentException.class));
        });
    }
}
