package rt.example.audio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rt.example.audio.model.Melody;
import rt.example.audio.repository.MelodyRepository;

@Controller
public class ClientController {
    @Autowired
    private MelodyRepository melodyRepository;


    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String reg(Model model){
        model.addAttribute("client", new Melody());
        return "registration";
    }

    @RequestMapping(value = "registration/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Melody client){
        this.melodyRepository.save(client);
        return "home";
    }
}