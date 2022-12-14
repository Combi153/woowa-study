package precourse.week1.problem3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void case1() {
        int number = 13;
        int result = 4;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void case2() {
        int number = 33;
        int result = 14;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}