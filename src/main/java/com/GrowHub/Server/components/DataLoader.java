package com.GrowHub.Server.components;

import com.GrowHub.Server.models.*;
import com.GrowHub.Server.models.enums.AreaType;
import com.GrowHub.Server.models.enums.Month;
import com.GrowHub.Server.models.enums.PositionType;
import com.GrowHub.Server.repositories.*;
import com.sun.corba.se.impl.oa.toa.TOAImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TipRepository tipRepository;

    @Autowired
    BulletinItemRepository bulletinItemRepository;

    @Autowired
    KnowhowRepository knowhowRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CommunalRepository communalRepository;

    // Plots, Crops, Comments (Area repository?)

    public DataLoader() {
    }

    // need to get rid of Long id in TextContent and children and then remove from below.
    // changed Area to AreaType in Job model

    public void run(ApplicationArguments args) {

        User AdministratorJanet = new User("MadJan", "madjan@hotmail.co.uk", "madjanlovesjam", PositionType.ORDINARY, 2014);
        userRepository.save(AdministratorJanet);

        User Mike = new User("MikeP", "bigmike@hotmail.co.uk", "pingpong2356", PositionType.COMMUNICATIONS, 2017);
        userRepository.save(Mike);

        User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.ORDINARY, 2016);
        userRepository.save(Andy);

        Communal communal1 = new Communal("Orchard", AreaType.ORCHARD, "20m2 area of fruit trees");
        communalRepository.save(communal1);

        Tip tip1 = new Tip("23/12/2020", AdministratorJanet, "New Year, new seeds!", "Place your seed order in January as it will soon be time to start sowing onions, cabbages, parsnips, leeks, sweet peas and calendula.", Month.JANUARY);
        tipRepository.save(tip1);

        Tip tip2 = new Tip("23/12/2020", AdministratorJanet, "Chitty chitty, spud spud", "Chit spuds in a cool, light place to develop healthy green shoots for planting from March onwards.", Month.FEBRUARY);
        tipRepository.save(tip2);

        Tip tip3 = new Tip("23/12/2020", AdministratorJanet, "Risk-free investments", "Try planting risk-free hardy veg that don’t mind the cold, such as carrots, peas, broad beans, spinach, radish, parsnips and leeks.", Month.MARCH);
        tipRepository.save(tip3);

        Tip tip4 = new Tip("23/12/2020", AdministratorJanet, "Well 'ard", "Start to harden off young plants with protection for planting out – keep a careful eye on the weather forecast.", Month.APRIL);
        tipRepository.save(tip4);

        Tip tip5 = new Tip("23/12/2020", AdministratorJanet, "Stop slugs in their tracks!", "If you have to use slug repellent, gardeners at The Eden Project recommend Advanced Slug Killer as it doesn’t harm the birds.", Month.MAY);
        tipRepository.save(tip5);

        Tip tip6 = new Tip("28/04/2021", AdministratorJanet, "Tough love", "If carrots, beetroot and lettuce seem overcrowded gently pull a few young plants up to allow others to swell. You can eat these baby veg.", Month.JUNE);
        tipRepository.save(tip6);

        Tip tip7 = new Tip("28/04/2021", AdministratorJanet, "Watch out, pests are about!", "It’s time to keep an eye out for plant pests. Check tips on young growing plants for clusters of greenflies, or for any distortion which might be aphids inside.", Month.JULY);
        tipRepository.save(tip7);

        Tip tip8 = new Tip("28/04/2021", AdministratorJanet, "What a-sprout now?", "Plant out brassicas, such as kale and sprouts, now and they’ll be ready in the winter. Planting them deeply promotes strong growth.", Month.AUGUST);
        tipRepository.save(tip8);

        Tip tip9 = new Tip("28/04/2021", AdministratorJanet, "Cool and collected", "Dig up potatoes carefully on a sunny day. Allow to dry before storing somewhere cool, dry and dark.", Month.SEPTEMBER);
        tipRepository.save(tip9);

        Tip tip10 = new Tip("28/04/2021", AdministratorJanet, "Ghhhaaarlic", "In the veg patch plant garlic cloves with their pointed ends up, and spaced 10cm apart.", Month.OCTOBER);
        tipRepository.save(tip10);

        Tip tip11 = new Tip("28/04/2021", AdministratorJanet, "Mulch to do", "Mulch bare vegetable areas to prevent winter rain from washing nutrients out of the soil.", Month.NOVEMBER);
        tipRepository.save(tip11);

        Tip tip12 = new Tip("28/04/2021", AdministratorJanet, "Can you dig it?", "If you love digging, on a dry day when the ground’s not frozen get out and turn the veg patch to let the frost in.", Month.DECEMBER);
        tipRepository.save(tip12);

        Job job1 = new Job("04/02/2021", Mike,"Toilet door", "The toilet door has rotted beyond repair and needs to be replaced", communal1, "30/06/2021", 5);
        jobRepository.save(job1);

        Job job2 = new Job("31/05/2021", Mike,"Tip trip", "There is a pile of bundled rubbish that needs to go to the tip, unless someone can repurpose any of it?", communal1, "10/07/2021", 2);
        jobRepository.save(job2);

        Job job3 = new Job("31/05/2021", Mike,"Wheelbarrow tyres", "The communal wheelbarrows (x2) need their tyres pumped up. Does anyone have a pump and the elbow grease to do it?", communal1, "28/06/2021", 2);
        jobRepository.save(job3);

        BulletinItem news1 = new BulletinItem("01/11/2020", Andy, "Lecture - free to attend", "The Botanic Society of Scotland is holding a free online lecture called 'What plant is that? Are smartphone apps the answer?', on 19/11/2020. If anyone is interested go to https://www.botanical-society-scotland.org.uk/category/news-events/lectures");
        bulletinItemRepository.save(news1);

        BulletinItem news2 = new BulletinItem("05/01/2021", Andy, "Welcome!", "A big welcome to new plot holder Jim Currie. Jim has taken on plot 52 and would be happy for any of you to pop by to say hello");
        bulletinItemRepository.save(news2);

        BulletinItem news3 = new BulletinItem("16/02/2021", AdministratorJanet, "Free carpet", "A delivery of old carpet, around 20m2, will arrive at the container on 18/02/2021. First come, first served. No fighting please! :-)");
        bulletinItemRepository.save(news3);

        BulletinItem news4 = new BulletinItem("23/04/2021", Mike, "New water supply installed", "Good news! The new water supply has been installed by the containers. Well done to Mary of plot 3 and Carl of plot 42 who made it happen! Thank you!");
        bulletinItemRepository.save(news4);

        Knowhow knowhow1 = new Knowhow("23/09/2020", Andy, "Chitting potatoes", "Leave your potatoes out 6 weeks before planting to allow the shoots to grow", Month.FEBRUARY);
        knowhowRepository.save(knowhow1);

        Knowhow knowhow2 = new Knowhow("13/01/2021", Andy, "Pruning fruit tress", "Prune fruit tress in October", Month.OCTOBER);
        knowhowRepository.save(knowhow2);

    }
}
