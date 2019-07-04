package tw.core.generator;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() {
        RandomIntGenerator randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        Mockito.when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        answerGenerator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void testGenerateMethod() throws OutOfRangeAnswerException {
        Answer answer = answerGenerator.generate();
        Assert.assertThat(answer.toString(), Is.is("1 2 3 4"));
    }
}

