package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    private final InputStream inputStream = System.in;
    private LottoMachine lottoMachine = new LottoMachine();

    @BeforeEach
    void setUp(){
        String testString = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
    }
    @AfterEach
    void rollBack(){
        System.setIn(inputStream);
    }
    @Test
    void readLottoPrice() {

    }

    @Test
    void calculateLottoCount() {
        int userMoney = lottoMachine.readLottoPrice();
        int lottoCount = lottoMachine.calculateLottoCount(userMoney);
        Assertions.assertThat(lottoCount).isEqualTo(8);
    }

    @Test
    void purchaseLotto() {

    }

    @Test
    void vendorLotto() {

    }

    private static Stream<Lotto> provideLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        return Stream.of(lotto);
    }
    @ParameterizedTest
    @MethodSource("provideLotto")
    void readWinningLotto(Lotto lotto){
        Lotto winningLotto = lottoMachine.readWinningNumber();
        Assertions.assertThat(winningLotto.getNumbers()).isEqualTo(lotto.getNumbers());
    }

    private static Stream<Arguments> provideWinningLottoAndCounterpart(){
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto counterPart = new Lotto(List.of(2,3,4,5,6,7));
        return Stream.of(Arguments.of(winningLotto,counterPart));
    }

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndCounterpart")
    void countMatchingNumbers(Lotto winning, Lotto counterpart) {
        int result = lottoMachine.countMatchingNumbers(winning, counterpart);
        Assertions.assertThat(result).isEqualTo(5);
    }
}