//package lotto;
//
//import org.junit.jupiter.api.Test;
//import camp.nextstep.edu.missionutils.test.NsTest;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class MoneyPurchaseTest extends NsTest {
//    private static final String ERROR_MESSAGE = "[ERROR]";
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() -> {
//            runException("1000j");
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }
//
//    @Override
//    protected void runMain() {
//        MoneyPurchase("1000j");
//    }
//}