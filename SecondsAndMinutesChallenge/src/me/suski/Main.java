package me.suski;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

        String output = getDurationString(65, 50);
        System.out.println(output);

        output = getDurationString(3950);
        System.out.println(output);

        output = getDurationString(61, 0);
        System.out.println(output);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = minutes / 60;
        minutes %= (hours * 60);

        String hoursStr = hours <= 10 ? "0" + hours : "" + hours;
        String minutesStr = minutes <= 10 ? "0" + minutes : "" + minutes;
        String secondsStr = seconds <= 10 ? "0" + seconds : "" + seconds;

        return hoursStr + "h " + minutesStr + "m " + secondsStr + "s";
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        int minutes = seconds / 60;
        seconds %= minutes * 60;
        return getDurationString(minutes, seconds);
    }
}
