package com.example.cs5500serverjava.webpages;

import com.example.cs5500serverjava.models.Activity;
import com.example.cs5500serverjava.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller class for activity data that puts the information into a model for displaying the
 * visualizations listed in "activity.html", "calories.html", and "timespent.html".
 */
@Controller
public class ActivityControllerWeb {

    @Autowired
    ActivityRepository activityRepository;


    //source used: https://www.chartjs.org/docs/latest/charts/bar.html
    @GetMapping("/api/user/date-recorded/segments/move/activity/graph/by-frequency")
    public String greeting(Model model) {

        int numberWalking = activityRepository.findNumberOfWalkingActivities();
        model.addAttribute("NumberWalkingActivities", numberWalking);

        int numberRunning = activityRepository.findNumberOfRunningActivities();
        model.addAttribute("NumberRunningActivities", numberRunning);

        int numberCycling = activityRepository.findNumberOfCyclingActivities();
        model.addAttribute("NumberCyclingActivities", numberCycling);

        int numberTransport = activityRepository.findNumberOfTransportActivities();
        model.addAttribute("NumberTransportActivities", numberTransport);

        //int numberKayaking = activityRepository.findNumberOfKayakingActivities();
        //model.addAttribute("NumberKayakingActivities", numberKayaking);

        int numberOther = activityRepository.findNumberOfOtherActivities();
        model.addAttribute("NumberOtherActivities", numberOther);

        return "activity";
    }

    //source used:https://www.chartjs.org/docs/latest/charts/doughnut.html
    @GetMapping("/api/user/date-recorded/segments/move/activity/graph/time-spent")
    public String timeSpent(Model model) {
        int timeWalking = activityRepository.findTotalTimeSpentOnWalking();
        model.addAttribute("TimeWalking", timeWalking);
        int timeRunning = activityRepository.findTotalTimeSpentOnRunning();
        model.addAttribute("TimeRunning", timeRunning);
        int timeCycling = activityRepository.findTotalTimeSpentOnCycling();
        model.addAttribute("TimeCycling", timeCycling);
        int timeTransport = activityRepository.findTotalTimeSpentOnTransport();
        model.addAttribute("TimeTransport", timeTransport);
        int timeOther = activityRepository.findTotalTimeSpentOnOther();
        model.addAttribute("TimeOther", timeOther);

        return "timespent";

    }

    //source used: https://www.chartjs.org/docs/latest/charts/line.html
    @GetMapping("/api/user/date-recorded/segments/move/activity/graph/calories/average")
    public String averageCaloriesForWalking(Model model) {

        int avgCalOfWalking = activityRepository.findAverageCaloriesForWalking();
        model.addAttribute("CaloriesWalking", avgCalOfWalking);

        int avgCalOfRunning = activityRepository.findAverageCaloriesForRunning();
        model.addAttribute("CaloriesRunning", avgCalOfRunning);

        int avgCalOfCycling = activityRepository.findAverageCaloriesForCycling();
        model.addAttribute("CaloriesCycling", avgCalOfCycling);

        int avgCalOfKayaking = activityRepository.findAverageCaloriesForKayaking();
        model.addAttribute("CaloriesKayaking", avgCalOfKayaking);

        int avgCalOfCrossCountrySkiing = activityRepository.findAverageCaloriesForCrossCountrySkiing();
        model.addAttribute("CaloriesCrossCountrySkiing", avgCalOfCrossCountrySkiing);

        return "calories";
    }



}
