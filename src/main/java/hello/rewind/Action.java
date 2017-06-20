package hello.rewind;

/**
 * Created by andrewevans on 18/06/2017.
 */

import org.springframework.data.annotation.Id;


public class Action {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Action() {}

    public Action(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, endpoint='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
