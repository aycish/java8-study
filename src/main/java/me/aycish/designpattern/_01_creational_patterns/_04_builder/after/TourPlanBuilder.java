package me.aycish.designpattern._01_creational_patterns._04_builder.after;

import me.aycish.designpattern._01_creational_patterns._04_builder.before.TourPlan;

import java.time.LocalDate;

public interface TourPlanBuilder {

    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder title(String title);
    TourPlanBuilder startDate(LocalDate localDate);
    TourPlanBuilder whereToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plan);

    TourPlan getPlan();
}
