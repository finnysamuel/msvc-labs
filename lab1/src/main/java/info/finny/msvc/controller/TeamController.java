package info.finny.msvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.finny.msvc.domain.Team;
import info.finny.msvc.repo.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired TeamRepository teamRepo;

	@RequestMapping ("/teamz")
	public Iterable<Team> getTeams(){
		return teamRepo.findAll();
	}
	
	@RequestMapping ("/teamz/{id}")
	public Team getTeamById(@PathVariable Long id){
		return teamRepo.findOne(id);
	}
}
