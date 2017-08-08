package hello.move;

import hello.movement.backwards.Backwards;
import hello.movement.forwards.Forwards;
import hello.movement.left.Left;
import hello.movement.right.Right;

public class MovementFactory {
    public Movement getMovement(String direction) {
        if (direction == null) {
            return null;
        }
        if (direction.equalsIgnoreCase("Forwards")) {
            return new Forwards();
        }
        if (direction.equalsIgnoreCase("Backwards")) {
            return new Backwards();
        }
        if (direction.equalsIgnoreCase("Left")) {
            return new Left();
        }
        if (direction.equalsIgnoreCase("Right")) {
            return new Right();
        }

        return null;
    }
}
