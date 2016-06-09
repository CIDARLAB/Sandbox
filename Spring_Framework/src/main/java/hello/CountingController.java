/*
    Controller for the Counting method. It handles GET requests for / by 
    returning the view counting. It handles POST requests by changing the count
    and then returning the view counting.
    
*/

package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountingController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String countingForm(Model model) {
        model.addAttribute("counting", new Counting());
        return "counting";
    }
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String countingAdd(@ModelAttribute Counting counting, Model model) {
        counting.setCount(counting.getCount() + 1);
        model.addAttribute("counting", counting);
        return "counting";
    }
    
    @RequestMapping(value="/subtract", method=RequestMethod.POST)
    public String countingSub(@ModelAttribute Counting counting, Model model) {
        counting.setCount(counting.getCount() - 1);
        model.addAttribute("counting", counting);
        return "counting";
    }
}