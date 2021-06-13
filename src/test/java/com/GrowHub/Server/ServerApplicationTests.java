package com.GrowHub.Server;

import com.GrowHub.Server.models.Communal;
import com.GrowHub.Server.models.Job;
import com.GrowHub.Server.models.Plot;
import com.GrowHub.Server.models.User;
import com.GrowHub.Server.models.enums.AreaType;
import com.GrowHub.Server.models.enums.PositionType;
import com.GrowHub.Server.repositories.CommunalRepository;
import com.GrowHub.Server.repositories.JobRepository;
import com.GrowHub.Server.repositories.PlotRepository;
import com.GrowHub.Server.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PlotRepository plotRepository;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	CommunalRepository communalRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void plotsStartOffEmpty() {
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		assertEquals(0, plot1.getUsers().size());
	}

	@Test
	void canAddUserToPlot() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		assertEquals(1, plot1.getUsers().size());
	}

	@Test
	void cannotAddUserToPlotIfAlreadyThere() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.addUser(Andy);
		assertEquals(1, plot1.getUsers().size());
	}

	@Test
	void canRemoveUserFromPlot() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.removeUser(Andy);
		assertEquals(0, plot1.getUsers().size());
	}

	@Test
	void cannotRemoveUserFromPlotIfNotThere() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		User Mike = new User("MikeP", "bigmike@hotmail.co.uk", "pingpong2356", PositionType.ORDINARY, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.removeUser(Mike);
		assertEquals(1, plot1.getUsers().size());
	}

	@Test
	void canFindUsersByPlotNumber() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(Andy);
		User Pauline = new User("PaulineB", "paulinelovescabbage@gmail", "whizkid763", PositionType.ORDINARY, 2016);
		userRepository.save(Pauline);
		User Brian = new User("BrianH", "mrlovemonster@gmail", "45lovemachine78", PositionType.ORDINARY, 2020);
		userRepository.save(Brian);

		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.addUser(Pauline);
		plot1.addUser(Brian);
		plotRepository.save(plot1);

		List<User> foundUsers = userRepository.findByPlotsPlotNumber(1);
		assertEquals(3, foundUsers.size());

	}

	@Test
	void canFindPlotsBelongingToUser() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(Andy);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plotRepository.save(plot1);
		Plot plot2 = new Plot("Plot 2",2, 5.50, 4.00, true);
		plot2.addUser(Andy);
		plotRepository.save(plot2);

		List<Plot> foundPlots = plotRepository.findByUsersShortName("AndyS");
		assertEquals(2, foundPlots.size());

	}

	@Test
	void canAddJobApplyingToCommunalArea() {
		User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(Andy);
		Communal communal4 = new Communal("Toilet", AreaType.TOILET, "Ecological toilet.");
		communalRepository.save(communal4);
		Job job1 = new Job("04/02/2021", Andy,"Toilet door", "The toilet door lock has broken and needs to be replaced.", communal4, "30/06/2021", 5);
		jobRepository.save(job1);

	}
}
