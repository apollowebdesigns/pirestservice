//package hello.rewind;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * Created by andrewevans on 18/06/2017.
// */
//@RestController
//public class ActionController {
//
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @Autowired
//    public ActionRepository repository;
//
//    @RequestMapping("/rewind")
//    public Action action(@RequestParam(value="name", defaultValue="Default") String name) throws InterruptedException {
//
//        repository.deleteAll();
//
//        // save a couple of actions
//        repository.save(new Action("right", "hits"));
//        repository.save(new Action("forwards", "hits"));
//
//        // fetch all actions
//        System.out.println("actions found with findAll():");
//        System.out.println("-------------------------------");
//        for (Action action : repository.findAll()) {
//            System.out.println(action);
//        }
//        System.out.println();
//
//        // fetch an individual action
//        System.out.println("action found with findByFirstName('right'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("right"));
//
//        System.out.println("actions found with findByLastName('hits'):");
//        System.out.println("--------------------------------");
//
//        Action foundaction = null;
//
//        for (Action action : repository.findByLastName("hits")) {
//            System.out.println(action);
//            foundaction = action;
//        }
//
//        System.out.println("what is the length");
//        System.out.println(repository.findAll().size());
//        return foundaction;
//    }
//}
