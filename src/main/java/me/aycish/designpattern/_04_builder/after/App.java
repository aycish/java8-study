package me.aycish.designpattern._04_builder.after;

import me.aycish.designpattern._04_builder.before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        /* 기본적인 빌더패턴 사용 방법 */
        TourPlanBuilder builder = new DefaultTourBuilder();
        TourPlan defaultPlan = builder.title("일본 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2023, 12, 9))
                .whereToStay("리조트")
                .addPlan(0, "체크인 및 짐풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();


        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.cancutTrip();
        TourPlan tourPlan1 = director.longBeachTrip();

    }
}
