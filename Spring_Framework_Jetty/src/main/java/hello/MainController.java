/*
    Controller for the Counting method. It handles GET requests for / by 
    returning the view counting. It handles POST requests for /add and /subtract by changing the count
    and then returning the view counting.
    
*/

package hello;

import org.clothoapi.clotho3javaapi.Clotho;
import org.clothoapi.clotho3javaapi.ClothoConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String countingForm() {
        return "index";
    }
    
    @RequestMapping(value="/connect", method=RequestMethod.GET)
    public String connect() {
        System.out.println("connect");
        ClothoConnection conn = new ClothoConnection(Args.clothoLocation);
        System.out.println("connectsuccess");
        Clotho clothoObject = new Clotho(conn);
        return "success";
    }
}