package com.itv.ITV205FirstSpringbootApp.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itv.ITV205FirstSpringbootApp.model.Player;
import com.itv.ITV205FirstSpringbootApp.service.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	PlayerService playerService;

	@RequestMapping("/addPlayerByPathVariable/{name}/{gender}")
	public String addPlayerByPathVariable(@PathVariable("name") String playername,
			@PathVariable("gender") String gender) {
		Player p1 = new Player();
		p1.setPlayerName(playername);
		p1.setGender(gender);

		playerService.addPlayer(p1);

		return "successInAdding";

	}

	@GetMapping("/register")
	public String getPlayerById(Model model) {
		Player p = new Player();
		model.addAttribute("myplayer", p);
		return "player-registration-form";
	}

	@PostMapping("/addPlayerByRequestBody")
	public String addPlayerByRequestBody(@ModelAttribute Player player) {
		playerService.addPlayer(player);
		return "redirect:/homepage";
	}

	@RequestMapping("/homepage")
	public String getAllPlayers(Model model) {
		List<Player> player = playerService.getAllPlayers();
		model.addAttribute("players", player);
		return "player-list";
	}

	@RequestMapping("/updatePlayerForm")
	public String updatePlayerForm(@RequestParam("id") int id, Model model) {
		Player player = playerService.getPlayerById(id);
		model.addAttribute("player", player);
		model.addAttribute("positions", Arrays.asList("forward", "midfielder", "defender", "goalkeeper"));
		model.addAttribute("skillLevels", Arrays.asList("beginner", "intermediate", "advanced", "professional"));
		return "update-player-form";
	}

	@RequestMapping("/updatePlayer")
	public String updatePlayer(@ModelAttribute Player player) {
		playerService.updatePlayer(player);
		return "redirect:/homepage";
	}

	@RequestMapping("/deletePlayer")
	public String deletePlayer(@RequestParam("id") int id) {
		playerService.deletePlayer(id);
		return "redirect:/homepage";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
