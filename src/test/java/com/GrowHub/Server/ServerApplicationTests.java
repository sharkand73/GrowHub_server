package com.GrowHub.Server;

import com.GrowHub.Server.models.*;
import com.GrowHub.Server.models.enums.AreaType;
import com.GrowHub.Server.models.enums.Month;
import com.GrowHub.Server.models.enums.PositionType;
import com.GrowHub.Server.repositories.*;
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

	@Autowired
	ReplyRepository replyRepository;

	@Autowired
	KnowhowRepository knowhowRepository;

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
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		assertEquals(1, plot1.getUsers().size());
		//assertEquals(1, Andy.getPlots().size());
	}

	@Test
	void cannotAddUserToPlotIfAlreadyThere() {
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.addUser(Andy);
		assertEquals(1, plot1.getUsers().size());
	}

	@Test
	void canRemoveUserFromPlot() {
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.removeUser(Andy);
		assertEquals(0, plot1.getUsers().size());
	}

	@Test
	void cannotRemoveUserFromPlotIfNotThere() {
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		User Mike = new User("MikeP",  "pingpong2356", PositionType.ORDINARY, 2017);
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(Andy);
		plot1.removeUser(Mike);
		assertEquals(1, plot1.getUsers().size());
	}

	@Test
	void canFindUsersByPlotNumber() {
//		Added 'S' onto the end of users/plots below, as once the DataLoader was made, the tests failed as more objects were (expectedly) found
		User AndyS = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(AndyS);
		User PaulineS = new User("PaulineS",  "whizkid763", PositionType.ORDINARY, 2016);
		userRepository.save(PaulineS);
		User BrianS = new User("BrianH",  "45lovemachine78", PositionType.ORDINARY, 2020);
		userRepository.save(BrianS);

		Plot plot1S = new Plot("Plot 1", 100, 5.4, 4.5, true);
		plot1S.addUser(AndyS);
		plot1S.addUser(PaulineS);
		plot1S.addUser(BrianS);
		plotRepository.save(plot1S);

		List<User> foundUsers = userRepository.findByPlotsPlotNumber(100);
		assertEquals(3, foundUsers.size());

	}

	@Test
	void canFindPlotsBelongingToUser() {
		User AndySS = new User("AndySS",  "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(AndySS);

		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		plot1.addUser(AndySS);
		plotRepository.save(plot1);

		Plot plot2 = new Plot("Plot 2",2, 5.50, 4.00, true);
		plot2.addUser(AndySS);
		plotRepository.save(plot2);

		List<Plot> foundPlots = plotRepository.findByUsersShortName("AndySS");
		assertEquals(2, foundPlots.size());

	}

	@Test
	void canAddJobApplyingToCommunalArea() {
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(Andy);
		Communal communal4 = new Communal("Toilet", AreaType.TOILET, "Ecological toilet.");
		communalRepository.save(communal4);
		Job job1 = new Job("04/02/2021", Andy,"Toilet door", "The toilet door lock has broken and needs to be replaced.", communal4, "30/06/2021", 5);
		jobRepository.save(job1);
		assertEquals(communal4, job1.getCommunal()); //passes

	}

	@Test
	void canGetReplyInfo(){
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		userRepository.save(Andy);

		Knowhow knowhow1 = new Knowhow("23/09/2020", Andy, "Chitting potatoes", "Leave your potatoes out 6 weeks before planting to allow the shoots to grow", Month.FEBRUARY);
		knowhowRepository.save(knowhow1);

		Reply reply1 = new Reply("Wow that's some good info", "16/06/2021", Andy, knowhow1);
		replyRepository.save(reply1);

		assertEquals(reply1.getAuthor(), Andy);
		assertEquals(reply1.getKnowhow(), knowhow1 );
	}

	@Test
	void canAddPlotToUser() {
		Plot plot1 = new Plot("Plot 1", 1, 5.4, 4.5, true);
		User Andy = new User("AndyS",  "jobbie101", PositionType.TREASURER, 2017);
		Andy.addPlot(plot1);
		assertEquals(1, Andy.getPlots().size());
	}
}
