package lotto.userService;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.user.User;
import lotto.domain.user.UserRepository;
import lotto.enums.LottoConstant;
import lotto.service.UserService;
import lotto.util.UserIdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserServiceTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    final UserService userService = UserService.getInstance();
    final UserRepository userRepository = UserRepository.getInstance();

    @BeforeEach
    void setUp() {
        UserIdGenerator.init();
        userRepository.deleteAll();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "8900", "0", "-1", "", " "})
    void 접근_시도_횟수_초과_예외_테스트(String purchasePrice) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run(purchasePrice))
                        .isInstanceOf(NoSuchElementException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "8900", "0", "-1", "", " "})
    void 구입_금액_유효성_검사_예외테스트(String inValidPurchasePrice) {
        assertThatThrownBy(() -> {
            new User(inValidPurchasePrice);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,2000","3000,4000"})
    void 사용자_조회_테스트(String firstValue, String secondValue) {
        // given
        User firstUser = userRepository.save(new User(firstValue));
        User secondUser = userRepository.save(new User(secondValue));

        // when
        User findFirstUser = userService.findById(firstUser.getId());
        User findSecondUser = userService.findById(secondUser.getId());


        // then
        assertThat(firstUser).isEqualTo(findFirstUser);
        assertThat(secondUser).isEqualTo(findSecondUser);
    }

    @DisplayName("유효한 구입 금액으로 사용자가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000"})
    void 유효한_구입_금액으로_사용자_생성(String validPurchasePrice) {
        // given
        User user = new User(validPurchasePrice);
        userRepository.save(user);

        // when
        User findUser = userService.findById(user.getId());

        // then
        assertThat(user).isNotNull();
        assertThat(findUser.getPurchasePrice()).isEqualTo(Integer.parseInt(validPurchasePrice));
    }

    @DisplayName("로또 티켓을 구매하면 사용자 로또 티켓 수가 증가한다.")
    @Test
    void 로또_티켓_구매_테스트() {
        // given
        String purchasePrice = "1000";
        User user = new User(purchasePrice);
        userRepository.save(user);

        // when
        User findUser = userService.findById(user.getId());
        userService.getLottoTickets(findUser.getId());

        int expectedTicketCount = user.getPurchasePrice() / LottoConstant.PRICE.getValue();
        assertThat(user.getLottoTickets().size()).isEqualTo(expectedTicketCount);
    }

    @DisplayName("존재하지 않는 사용자 ID에 대해 조회 시 예외가 발생한다.")
    @Test
    void 존재하지_않는_사용자_ID_조회_예외처리() {
        assertThatThrownBy(() -> userService.findById(999))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
