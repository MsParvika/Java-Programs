import java.util.*;

class SortDate {

    public static List<String> sortDates(List<String> dates) {
        java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("dd MMM yyyy");
        Collections.sort(dates,
                (x, y) -> java.time.LocalDate.parse(x, dateTimeFormatter).compareTo(java.time.LocalDate.parse(y, dateTimeFormatter)));
        return dates;
    }

    public static void main(String arg[]) {
        SortDate sortDate = new SortDate();
        List<String> dates = new ArrayList<String>(Arrays.asList("26 Jan 1992","31 Dec 1883","12 Jun 2018","25 Mar 2000"));
        List<String> result = sortDate.sortDates(dates);
        for(String r : result){
            System.out.println(r);
        }
    }
}
