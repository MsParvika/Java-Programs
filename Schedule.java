import java.util.*;

class Schedule {

    static List<String> result;
    static int hoursRemaining;
    static String inputPattern;
    static int hoursLimit;

    static int[] schedulesSeries;

    public static void findScheduleSeries(int seriesLength, int hoursScheduled) {
        if (hoursScheduled > hoursRemaining)
            return;
        if (seriesLength == schedulesSeries.length) {
            int totalHours = 0;
            for (int i = 0; i < schedulesSeries.length; i++) {
                totalHours += schedulesSeries[i];
            }
            if (totalHours == hoursRemaining) {
                StringBuilder pattern = new StringBuilder();
                int index = 0;
                for (int i = 0; i < inputPattern.length(); i++) {
                    if (inputPattern.charAt(i) != '?') {
                        pattern.append(inputPattern.charAt(i));
                    } else
                        pattern.append(schedulesSeries[index++]);
                }
                result.add(pattern.toString());
            }
            return;
        }
        for (int i = 0; i <= hoursLimit; i++) {
            schedulesSeries[seriesLength] = i;
            findScheduleSeries(seriesLength + 1, hoursScheduled + i);
        }
    }

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        result = new ArrayList<String>();
        inputPattern = pattern;
        int daysAllocated = 0;
        int hoursAllocated = 0;
        for (int i = 0; i < 7; i++) {
            if (pattern.charAt(i) != '?') {
                hoursAllocated += pattern.charAt(i) - '0';
            } else {
                daysAllocated++;
            }
        }
        hoursRemaining = workHours - hoursAllocated;
        hoursLimit = dayHours;
        schedulesSeries = new int[daysAllocated];
        findScheduleSeries(0, 0);
        return result;
    }

    public static void main(String arg[]) {
        Schedule schedule = new Schedule();
        String pattern = "???234?";
        List<String> result = schedule.findSchedules(26, 8, pattern);
        for(String r : result){
            System.out.println(r);
        }
    }
}
