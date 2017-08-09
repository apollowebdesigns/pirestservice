package hello.move;

import hello.movement.backwards.Backwards;
import hello.movement.forwards.Forwards;
import hello.movement.left.Left;
import hello.movement.right.Right;

public class MovementFactory {

    private MovementFactory() {}

    private static MovementFactory instance = new MovementFactory();

    public static MovementFactory getInstance() {
        return instance;
    }

    public Movement getDirection(Direction direction) {
        if (direction == null) {
            return null;
        }
        if (direction.equals(Direction.FORWARDS)) {
            return new Forwards();
        }
        if (direction.equals(Direction.BACKWARDS)) {
            return new Backwards();
        }
        if (direction.equals(Direction.LEFT)) {
            return new Left();
        }
        if (direction.equals(Direction.RIGHT)) {
            return new Right();
        }

        return null;
    }
}
