package hello.unit;

import hello.move.Direction;
import hello.move.MovementFactory;
import hello.movement.backwards.Backwards;
import hello.movement.forwards.Forwards;
import hello.movement.left.Left;
import hello.movement.right.Right;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovementFactoryTest {

    @Test
    public void getForwards() throws Exception {
        MovementFactory movementFactorySpy = MovementFactory.getInstance();
        Forwards result = (Forwards) movementFactorySpy.getDirection(Direction.FORWARDS);
        Forwards testCase = new Forwards();
        Assert.assertTrue(result.getClass().equals(testCase.getClass()));
    }

    @Test
    public void getBackwards() throws Exception {
        MovementFactory movementFactorySpy = MovementFactory.getInstance();
        Backwards result = (Backwards) movementFactorySpy.getDirection(Direction.BACKWARDS);
        Backwards testCase = new Backwards();
        Assert.assertTrue(result.getClass().equals(testCase.getClass()));
    }

    @Test
    public void getLeft() throws Exception {
        MovementFactory movementFactorySpy = MovementFactory.getInstance();
        Left result = (Left) movementFactorySpy.getDirection(Direction.LEFT);
        Left testCase = new Left();
        Assert.assertTrue(result.getClass().equals(testCase.getClass()));
    }

    @Test
    public void getRight() throws Exception {
        MovementFactory movementFactorySpy = MovementFactory.getInstance();
        Right result = (Right) movementFactorySpy.getDirection(Direction.RIGHT);
        Right testCase = new Right();
        Assert.assertTrue(result.getClass().equals(testCase.getClass()));
    }
}