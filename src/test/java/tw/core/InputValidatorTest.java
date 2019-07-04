package tw.core;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void testValidate1() {
        Boolean result = new InputValidator().validate("1 2 2 1");
        Assert.assertThat(result, Is.is(false));
    }

    @Test
    public void testValidate2() {
        Boolean result = new InputValidator().validate("1 2 3 4");
        Assert.assertThat(result, Is.is(true));
    }
}
