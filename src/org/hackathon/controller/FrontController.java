package org.hackathon.controller;

import org.hackathon.domain.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontController {

	/*@Autowired
	PlayerDao playerDao;*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        
        return "welcome";
    }
	
	// show add Player form
	@RequestMapping(value = "/users/players/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Player player = new Player();
		model.addAttribute("playerForm", player);
		return "user/player/playerform";

	}

	
	@RequestMapping(value = "/users/players", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("playerForm") Player player) {

		//Player player = new Player();
		
		//playerDao.save(player);
		
		//model.addAttribute("playerForm", player);
		return "welcome";

	}
	
	@RequestMapping(value = "/users/players", method = RequestMethod.GET)
	public String getAllPlayers(Model model) {

		//Player player = new Player();
		//List<Player> players = playerDao.findAll();
		//model.addAttribute("players", players);		
		//model.addAttribute("playerForm", player);
		return "user/player/list";

	}
}
