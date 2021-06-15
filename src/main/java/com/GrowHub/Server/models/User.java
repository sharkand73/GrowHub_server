package com.GrowHub.Server.models;
import com.GrowHub.Server.models.enums.PositionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String shortName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private PositionType position;

    @Column
    private int yearJoined;

    @Column
    private int yearLeft;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_plots",
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "plot_id", nullable = false, updatable = false)
            }
    )
    private List<Plot> plots;

//    @JsonBackReference
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "plots_jobs",
//            joinColumns = {
//                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "job_id", nullable = false, updatable = false)
//            }
//    )
//    private List<Job> userJobs;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_crops",
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "crop_id", nullable = false, updatable = false)
            }
    )
    private List<Crop> crops;

    @JsonIgnoreProperties(value="plots")
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Reply> replies;

    @JsonIgnoreProperties(value = "author")
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Job> jobs;

    @JsonIgnoreProperties(value = "author")
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<BulletinItem> bulletinItems;

    @JsonIgnoreProperties(value = "author")
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Knowhow> knowhows;

    //CONSTRUCTOR
    public User(String shortName, String email, String password, PositionType position, int yearJoined) {
        this.shortName = shortName;
        this.email = email;
        this.password = password;
        this.position = position;
        this.yearJoined = yearJoined;
        this.yearLeft = 0;
        this.crops = new ArrayList<>();
        this.plots = new ArrayList<>();
        this.replies = new ArrayList<>();
        this.knowhows = new ArrayList<>();
        this.bulletinItems = new ArrayList<>();
        this.jobs = new ArrayList<>();

    }
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getYearLeft() {
        return yearLeft;
    }

    public void setYearLeft(int yearLeft) {
        this.yearLeft = yearLeft;
    }

    @JsonIgnore
    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }

    @JsonIgnore
    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @JsonIgnore
    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @JsonIgnore
    public List<BulletinItem> getBulletinItems() {
        return bulletinItems;
    }

    public void setBulletinItems(List<BulletinItem> bulletinItems) {
        this.bulletinItems = bulletinItems;
    }

    @JsonIgnore
    public List<Knowhow> getKnowhows() {
        return knowhows;
    }

    public void setKnowhows(List<Knowhow> knowhows) {
        this.knowhows = knowhows;
    }

    // adders
    public void addReply(Reply reply){
        this.replies.add(reply);
    }

    public void addKnowhow(Knowhow knowhow){
        this.knowhows.add(knowhow);
    }

    public void addBulletinItem(BulletinItem bulletinItem){
        this.bulletinItems.add(bulletinItem);
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }

    public void addPlot(Plot plot){
        this.plots.add(plot);
    }

}
