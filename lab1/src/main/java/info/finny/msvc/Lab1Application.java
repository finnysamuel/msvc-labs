package info.finny.msvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import info.finny.msvc.domain.Player;
import info.finny.msvc.domain.Team;
import info.finny.msvc.repo.TeamRepository;

@SpringBootApplication
public class Lab1Application {
	
	@Autowired TeamRepository teamRepo;
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}
	
	@PostConstruct
	public void init(){
		List<Team> list = new ArrayList<>();

		Set<Player> team1players = new HashSet<Player>();
		team1players.add(new Player("Name 1", "Pos 1"));
		team1players.add(new Player("Name 2", "Pos 2"));
		team1players.add(new Player("Name 3", "Pos 3"));
		
		Set<Player> team2players = new HashSet<Player>();
		team2players.add(new Player("Name 10", "Pos 1"));
		team2players.add(new Player("Name 11", "Pos 2"));
		team2players.add(new Player("Name 12", "Pos 3"));
		
		Team team = new Team("Harlem", "Globetrotters", "Elephant", team1players);
		list.add(team);
		team = new Team("Washington","Generals","Mickey",team2players);
		list.add(team);

		teamRepo.save(list);
	}
}
