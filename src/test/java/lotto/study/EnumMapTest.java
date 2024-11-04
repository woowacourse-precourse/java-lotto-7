package lotto.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.*;

class EnumMapTest {

    enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Test
    @DisplayName("EnumMap 기본 동작 테스트")
    void basicEnumMapTest() {
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

        schedule.put(DayOfWeek.MONDAY, "Work");
        schedule.put(DayOfWeek.SATURDAY, "Hiking");
        schedule.put(DayOfWeek.SUNDAY, "Rest");

        assertThat(schedule).hasSize(3);
        assertThat(schedule.get(DayOfWeek.MONDAY)).isEqualTo("Work");
        assertThat(schedule.containsKey(DayOfWeek.SATURDAY)).isTrue();
    }

    @Test
    @DisplayName("EnumMap은 null 키를 허용하지 않는다")
    void nullKeyNotAllowed() {
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

        assertThatThrownBy(() -> schedule.put(null, "Test"))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("EnumMap의 키 순서는 Enum 선언 순서와 동일하다")
    void enumMapMaintainsOrder() {
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);

        schedule.put(DayOfWeek.WEDNESDAY, "Meeting");
        schedule.put(DayOfWeek.MONDAY, "Work");
        schedule.put(DayOfWeek.FRIDAY, "Report");

        assertThat(schedule.keySet())
            .containsExactly(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
    }

    @Test
    @DisplayName("EnumMap의 값 변경과 제거")
    void modificationOperations() {
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);
        schedule.put(DayOfWeek.MONDAY, "Work");

        schedule.replace(DayOfWeek.MONDAY, "Meeting");
        schedule.remove(DayOfWeek.MONDAY);

        assertThat(schedule).isEmpty();
    }

    @Test
    @DisplayName("EnumMap을 사용한 실제 비즈니스 로직 예제")
    void businessLogicExample() {
        enum PaymentStatus {
            PENDING, PROCESSING, COMPLETED, FAILED
        }

        EnumMap<PaymentStatus, Integer> paymentStats = new EnumMap<>(PaymentStatus.class);

        paymentStats.put(PaymentStatus.PENDING, 5);
        paymentStats.put(PaymentStatus.PROCESSING, 3);
        paymentStats.put(PaymentStatus.COMPLETED, 10);
        paymentStats.put(PaymentStatus.FAILED, 2);

        paymentStats.merge(PaymentStatus.COMPLETED, 1, Integer::sum);

        assertThat(paymentStats.get(PaymentStatus.COMPLETED)).isEqualTo(11);
        assertThat(paymentStats.values().stream().mapToInt(Integer::intValue).sum())
            .isEqualTo(21);
    }
}