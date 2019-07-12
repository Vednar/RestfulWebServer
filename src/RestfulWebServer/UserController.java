package RestfulWebServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.webservices.client.HttpWebServiceMessageSenderBuilder;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(value = "/add_user")
    public int addNewUser(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam(value = "phone", required = false) String phoneNumber) {

        return Mock.addUser(name, email, phoneNumber);
    }

    @RequestMapping(value = "/get_user")
    public ResponseEntity<User> getUser(@RequestParam(value = "id") String id) {
        User usr;
        try {
            usr = Mock.getUser(Integer.parseInt(id));
            return new ResponseEntity<>(usr, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/change_status")
    public ResponseEntity<List<String>> changeStatus(@RequestParam(value = "id") String id,
                                                     @RequestParam(value = "status", required = true) String status) {
        try {
            List<String> lst = new ArrayList<>();
            lst.add(id);
            lst.add(Mock.changeStatus(Integer.parseInt(id), status));
            lst.add(status);
            return new ResponseEntity<>(lst, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}