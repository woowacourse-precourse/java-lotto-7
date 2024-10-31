package lotto.userService;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.User;
import lotto.domain.UserRepository;
import lotto.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserServiceTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    final UserService userService = UserService.getInstance();
    final UserRepository userRepository = UserRepository.getInstance();

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "8900", "0", "-1", "", " "})
    void 접근_시도_횟수_초과_예외_테스트(String purchasePrice) {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(purchasePrice))
                        .isInstanceOf(IllegalStateException.class)
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

    @Test
    void 사용자_조회_테스트() {
        // given
        User firstUser = userRepository.save(new User("1000"));
        User secondUser = userRepository.save(new User("2000"));

        // when
        User findFirstUser = userService.findById(firstUser.getId());
        User findSecondUser = userService.findById(secondUser.getId());


        // then
        assertThat(firstUser).isEqualTo(findFirstUser);
        assertThat(secondUser).isEqualTo(findSecondUser);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
