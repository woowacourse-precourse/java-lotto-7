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

    @Test
    void 사용자_저장_테스트() {
        // given
        int purchasePrice = 1000;

        // when
        userService.save(purchasePrice);
        User user = userRepository.findAll().getFirst();

        // then
        assertThat(user.getPurchasePrice()).isEqualTo(purchasePrice);
    }

    @Test
    void 사용자_조회_테스트() {
        // given
        int purchasePrice = 1000;
        int firstUserId = userService.save(purchasePrice);
        int secondUserId = userService.save(purchasePrice);

        // when
        User findFirstUser = userService.findById(firstUserId);
        User firstUser = userRepository.findAll().get(firstUserId);

        User secondFirstUser = userService.findById(secondUserId);
        User secondUser = userRepository.findAll().get(secondUserId);



        // then
        assertThat(findFirstUser).isEqualTo(firstUser);
        assertThat(secondFirstUser).isEqualTo(secondUser);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
