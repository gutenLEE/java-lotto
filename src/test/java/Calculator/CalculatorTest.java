package Calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void blankOrNullInputTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(input));
    }


    @Test
    public void 덧셈() {
        int sut = Calculator.calculate("1 + 2");
        assertThat(sut).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int sut = Calculator.calculate("2 - 1");
        assertThat(sut).isEqualTo(1);
    }

    @Test
    public void 나눗셈() {
        int sut = Calculator.calculate("4 / 2");
        assertThat(sut).isEqualTo(2);
    }


    @Test
    public void 곱셈() {
        int sut = Calculator.calculate("4 * 2");
        assertThat(sut).isEqualTo(8);
    }

    @Test
    public void 사칙연산_순서무시() {
        int sut = Calculator.calculate("4 * 2 + 3");
        assertThat(sut).isEqualTo(11);
    }

    @Test
    public void 연산기호가_아니면_예외발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate("4 & 2 + 3");
        }).withMessage("operation must be - / * +");
    }



}