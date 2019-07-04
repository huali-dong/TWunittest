package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import java.io.IOException;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    @Mock
    private GameView gameView;
    @Mock
    private GuessInputCommand guessInputCommand;
    @Mock
    private AnswerGenerator answerGenerator;

    private Answer actualAnswer = Answer.createAnswer("1 2 3 4");

    private Game game;
    private GameController gameController;

    @Before
    public void setUp() throws OutOfRangeAnswerException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
        gameController = new GameController(game, gameView);
    }

    @Test
    public void testBeginGameMethod() throws IOException {
        gameController.beginGame();
        Mockito.verify(gameView).showBegin();
    }

    @Test
    public void testPlayMethod() throws IOException {
        Mockito.when(guessInputCommand.input()).thenReturn(actualAnswer, Answer.createAnswer("2 3 4 5"));
        gameController.play(guessInputCommand);
        Mockito.verify(gameView).showGameStatus(Mockito.anyString());
        Mockito.verify(gameView).showGuessHistory(Mockito.anyList());
        Mockito.verify(gameView).showGuessResult(Mockito.any());
    }
}