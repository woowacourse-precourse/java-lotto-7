package lotto.domain;

/**
 * 로또의 핵심 로직인 겹치는 Component 수를 세를 것과
 * 로또를 출력하는 것에 필요한 매서드입니다.
 */
public interface Component {

    boolean equals(Object o);

    int hashCode();

    String toString();
}
