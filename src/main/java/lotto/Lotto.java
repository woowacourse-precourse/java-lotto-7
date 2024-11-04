package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 당첨 번호 입력 유효성 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현

    // 유효성 검사가 제외된 생성자 오버로딩
    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    // 구매 갯수(n)만큼 로또 발행 메소드
    public List<Lotto> number_generator(int n) {
        List<Lotto> lottos = new ArrayList<>();
        while (n-- > 0) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    // 발행된 로또 출력 메소드
    public void number_print() {
        String message = "[";
        for (int n : this.numbers) {
            message += n + ", ";
        }
        message = message.substring(0, message.length() - 2) + "]";
        System.out.println(message);
    }

    // 발행 로또와 당첨 번호 비교 메소드
    public int number_matching(Lotto win_Num) {
        int match;
        Set<Integer> matching_count = new HashSet<>(this.numbers);
        matching_count.retainAll(win_Num.numbers);
        match = matching_count.size();
        return match;
    }

    // 보너스 번호 비교 메소드(2등 인지, 3등인지)
    public boolean bonus_matching(int bonus_Num) {
        boolean match = false;
        for (int n : this.numbers) {
            if (n == bonus_Num) {
                match = true;
            }
        }
        return match;
    }

    // 보너스 번호 입력 유효성 검사
    public void bonus_validate(int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
