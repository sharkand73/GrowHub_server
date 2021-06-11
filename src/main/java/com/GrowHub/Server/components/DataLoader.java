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

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    CropRepository cropRepository;

    @Autowired
    CommentRepository commentRepository;


    public DataLoader() {
    }


    public void run(ApplicationArguments args) {

        User AdministratorJanet = new User("MadJan", "madjan@hotmail.co.uk", "madjanlovesjam", PositionType.ORDINARY, 2014);
        userRepository.save(AdministratorJanet);

        User Mike = new User("MikeP", "bigmike@hotmail.co.uk", "pingpong2356", PositionType.COMMUNICATIONS, 2017);
        userRepository.save(Mike);

        User Andy = new User("AndyS", "soilmuncher@hotmail.co.uk", "jobbie101", PositionType.ORDINARY, 2016);
        userRepository.save(Andy);

        User Pauline = new User("PaulineB", "paulinelovescabbage@gmail", "whizkid763", PositionType.ORDINARY, 2017);
        userRepository.save(Pauline);

        User Brian = new User("BrianH", "mrlovemonster@gmail", "45lovemachine78", PositionType.ORDINARY, 2020);
        userRepository.save(Brian);

        Plot plot1 = new Plot("Plot", 1, 5.4, 4.5, true);
        plotRepository.save(plot1);

        Plot plot2 = new Plot("Plot",2, 5.50, 4.00, true);
        plotRepository.save(plot2);

        Plot plot3 = new Plot("Plot",3, 6.90, 3.90, true);
        plotRepository.save(plot2);

        Plot plot4 = new Plot("Plot",4, 6.00, 3.50, true);
        plotRepository.save(plot4);

        Plot plot5 = new Plot("Plot",5, 6.10, 3.50, true);
        plotRepository.save(plot5);

        Plot plot6 = new Plot("Plot",5, 7.00, 4.50, false);
        plotRepository.save(plot6);

        Plot plot7 = new Plot("Plot",7, 7.10, 4.40, false);
        plotRepository.save(plot7);

        Plot plot8 = new Plot("Plot",8, 7.00, 4.60, false);
        plotRepository.save(plot8);

        Plot plot9 = new Plot("Plot",9, 6.90, 5.10, false);
        plotRepository.save(plot9);

        Plot plot10 = new Plot("Plot",10, 6.20, 4.20, true);
        plotRepository.save(plot10);

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

        Knowhow knowhow2 = new Knowhow("13/01/2021", Andy, "Spring onions", "September is one of the busiest months with harvesting. It’s worth sowing some winter hardy spring onions ready for spring. I stick with White Lisbon, which never fails me, but make sure you get winter hardy.", Month.SEPTEMBER);
        knowhowRepository.save(knowhow2);

        Knowhow knowhow3 = new Knowhow("25/04/2021", Mike, "Growing potatoes", "My lesson - not learned but taught by my next door neighbour is to make as much compost as you can. I was amazed at my success with potatoes which were planted in rich soil with lots of compost in it.", Month.APRIL);
        knowhowRepository.save(knowhow3);

        Knowhow knowhow4 = new Knowhow("03/01/2021", Pauline, "Leeks", "Dig a shallow trench, dig up your leeks in good weather and trim the roots. Lay them in the trench at an angle so most of the leek is out of the trench and cover with loose soil. When you want some, just pull without any strain", Month.JANUARY);
        knowhowRepository.save(knowhow4);

        Knowhow knowhow5 = new Knowhow("13/02/2021", Pauline, "Parsnips", "Conventional advice is often to sow parsnips in Feb but I believe their reputation for poor germination rates is due to being placed in cold wet soil and I have had much better germination rates by sowing in March or even April.", Month.FEBRUARY);
        knowhowRepository.save(knowhow5);

        Knowhow knowhow6 = new Knowhow("15/011/2020", AdministratorJanet, "Bean harvesting", "Your runner beans will be at the top of the canes in August so pinch out their growing tip to encourage bushier growth below. Pick all runner, climbing and dwarf beans regularly.", Month.AUGUST);
        knowhowRepository.save(knowhow6);

        Crop crop1 = new Crop("carrots");
        cropRepository.save(crop1);

        Crop crop2 = new Crop("cabbages");
        cropRepository.save(crop2);

        Crop crop3 = new Crop("curly kale");
        cropRepository.save(crop3);

        Crop crop4 = new Crop("long beans");
        cropRepository.save(crop4);

        Crop crop5 = new Crop("french beans");
        cropRepository.save(crop5);

        Crop crop6 = new Crop("courgettes");
        cropRepository.save(crop6);

        Crop crop7 = new Crop("broccoli");
        cropRepository.save(crop7);

        Crop crop8 = new Crop("beetroot");
        cropRepository.save(crop8);

        Crop crop9 = new Crop("potatoes");
        cropRepository.save(crop9);

        Crop crop10 = new Crop("garlic");
        cropRepository.save(crop10);

        Crop crop11 = new Crop("parsnips");
        cropRepository.save(crop11);

        Crop crop12 = new Crop("lettuce");
        cropRepository.save(crop12);

        Crop crop13 = new Crop("tomatoes");
        cropRepository.save(crop13);

        Crop crop14 = new Crop("spring onions");
        cropRepository.save(crop14);

        Crop crop15 = new Crop("brown onions");
        cropRepository.save(crop15);

        Crop crop16 = new Crop("shallots");
        cropRepository.save(crop16);

        Crop crop17 = new Crop("leeks");
        cropRepository.save(crop17);

        Crop crop18 = new Crop("mint");
        cropRepository.save(crop18);

        Crop crop19 = new Crop("raspberries");
        cropRepository.save(crop19);

        Crop crop20 = new Crop("strawberries");
        cropRepository.save(crop20);

        Comment comment1job1 = new Comment("11/02/2021", Pauline, "Toilet", "Could I suggest we use a shower curtain in the meantime? Secure the sides with clothes pegs", plot1);
        commentRepository.save(comment1job1);

        Comment comment2job3 = new Comment("02/06/2021", Brian, "Wheelbarrow tyres", "I have pump and can do it on Saturday", plot2);
        commentRepository.save(comment2job3);

        Comment comment3knowhow2 = new Comment("14/01/2021", Mike, "Also...", "I do the same myself Andy. You can also plant your sprouts now for Christmas", plot3);
        commentRepository.save(comment3knowhow2);

        // Does a comment really need the plot stated? It already has a user and should we know the plot through the user?
        // At the moment I can't tell which plot to give the comments anyway as I'm not sure which user has which plot?

        // Do we want plot users to be able to add comments (history) to their plots? Do we need to add String history
        // to Plot model? Or if we want them to be able to made multiple comments to their plot (rather than edit the one string) we would
        // need a new model called plotComment and a new List attribute for them in Plot?

    }
}
