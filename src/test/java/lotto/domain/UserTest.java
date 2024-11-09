package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class UserTest {

    @DisplayName("뽑은 숫자는 1~45의 범위안에 존재하고,고유해야 한다.")
    @Test
    void pickNumbersSorted() {
        User user = new User(10000);
        List<Integer> pickedNumbersSorted = user.pickNumbersSorted();
        List<Integer> distinct = pickedNumbersSorted.stream().distinct().toList();
        Assertions.assertThat(pickedNumbersSorted.size()).isEqualTo(distinct.size());
        pickedNumbersSorted.forEach(num -> {
            Assertions.assertThat(num).isBetween(1,45);
        });
    }
}