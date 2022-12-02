package precourse.week1.problem4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void case1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}