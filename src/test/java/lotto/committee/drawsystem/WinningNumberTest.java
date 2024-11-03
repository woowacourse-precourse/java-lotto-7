package lotto.committee.drawsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.MessageCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {

    WinningNumbers winningNumbers;
    DrawMachine drawMachine;
    List<Integer> mainNumbers;
    Integer bonusNumber;

    @BeforeEach
    public void setUp() {
        winningNumbers = WinningNumbers.forTest();
        drawMachine = DrawMachine.forTest(winningNumbers);
        mainNumbers = winningNumbers.getMainNumbers();
        bonusNumber = winningNumbers.getBonusNumber();
    }

    @Test
    @DisplayName("당첨번호 중 일반번호는 6개이다.")
    void 당첨번호_중_일반번호는_6개이다() {
        List<Integer> mainNumbers = winningNumbers.getMainNumbers();
        assertThat(mainNumbers.size()).isEqualTo(6);

    }

    @Test
    @DisplayName("이미_추첨완료된_당첨번호에_번호를_추가하려고_하면_예외가_발생한다.")
    void 이미_추첨완료된_당첨번호에_번호를_추가하려고_하면_예외가_발생한다() {
        assertThatThrownBy(() -> winningNumbers.addMainNumbers(List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_MESSAGE.get());
        assertThatThrownBy(() -> winningNumbers.addBonusNumber(23))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("추첨 전 당첨번호는 Null이다.")
    void 추첨_전_당첨번호는_Null이다() {
        WinningNumbers before = WinningNumbers.forTest();
        assertThat(before).hasAllNullFieldsOrProperties();
    }

    @Test
    @DisplayName("추첨완료 후 당첨번호는 Null이 아니다.")
    void 추첨완료_후_당첨번호는_Null이_아니다() {
        assertThat(winningNumbers.getBonusNumber()).isNotNull();
        assertThat(winningNumbers.getMainNumbers()).isNotNull();
    }

    @Test
    @DisplayName("당첨번호끼리는 겹치지 않는다.")
    void 당첨번호끼리는_겹치지_않는다() {

        List<Integer> numbers = new ArrayList<>(mainNumbers);
        numbers.add(bonusNumber);
        int count = numbers.size();
        Stream<Integer> deleteDuplicate= numbers.stream().distinct();

        assertThat(deleteDuplicate).hasSize(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE})
    @DisplayName("일반번호묶음을 수정하려고 하면 예외가 발생한다.")
    void 일반번호묶음을_수정하려고_하면_예외가_발생한다(Integer number) {
        assertThatThrownBy(() -> mainNumbers.add(number));
    }

    @Test
    @DisplayName("일반번호묶음에는 1부터 45 사이의 정수만 존재한다.")
    void 일반번호묶음에는_1부터_45_사이의_정수만_존재한다() {
        List<Integer> oneToFourtyFive = new ArrayList<>();
        oneToFourtyFive = IntStream.rangeClosed(1,45).boxed().toList();
        assertThat(mainNumbers).allMatch(oneToFourtyFive :: contains);
    }

    @Test
    @DisplayName("보너스번호는 1부터 45 사이의 정수이다.")
    void 보너스번호는_1부터_45_사이의_정수이다() {
        List<Integer> oneToFourtyFive = new ArrayList<>();
        oneToFourtyFive = IntStream.rangeClosed(1,45).boxed().toList();
        assertThat(bonusNumber).matches(oneToFourtyFive::contains);
    }
}
