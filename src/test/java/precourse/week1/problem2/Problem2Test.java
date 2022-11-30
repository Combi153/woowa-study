package precourse.week1.problem2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void case1() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "zyelleyz";
        String result = "";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}