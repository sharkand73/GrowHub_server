package com.GrowHub.Server;

import com.GrowHub.Server.models.Plot;
import com.GrowHub.Server.models.User;
import com.GrowHub.Server.models.enums.PositionType;
import com.GrowHub.Server.repositories.PlotRepository;
import com.GrowHub.Server.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PlotRepository plotRepository;

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

}
