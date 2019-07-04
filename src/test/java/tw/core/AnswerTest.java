package tw.core;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void testCreateAnswerMethod() {
        Assert.assertThat(actualAnswer.toString(), Is.is("1 2 3 4"));
    }

    @Test
    public void testValidateMethodAndThrowException() throws OutOfRangeAnswerException {
        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage(Is.is("Answer format is incorrect"));
        Answer answer = Answer.createAnswer("1 2 3 3");
        answer.validate();
    }

    @Test
    public void testCheckMethodAndReturn0A4B() {
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");
        Record record = actualAnswer.check(inputAnswer);
        Assert.assertThat(record.getValue(), Is.is("0A4B"));
    }

    @Test
    public void testCheckMethodAndReturn4A0B() {
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");
        Record record = actualAnswer.check(inputAnswer);
        Assert.assertThat(record.getValue(), Is.is("4A0B"));
    }

    @Test
    public void testCheckMethodAndReturn1A3B() {
        Answer inputAnswer = Answer.createAnswer("1 3 4 2");
        Record record = actualAnswer.check(inputAnswer);
        Assert.assertThat(record.getValue(), Is.is("1A3B"));
    }

}
