import java.text.SimpleDateFormat;
import java.util.Date;

/*Clock类用于模拟一个时钟，存储当前时间信息，根据不同时区进行初始化。*/
public class Clock {
    private String time;

    public Clock(String timeZone) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        switch (timeZone) {
            case "london":
                date.setTime(date.getTime()-28800000);
                break;
            case "moscow":
                date.setTime(date.getTime()-14400000);
                break;
            case "sydney":
                date.setTime(date.getTime()+7200000);
                break;
            case "newyork":
                date.setTime(date.getTime()-46800000);
                break;
            default:
                break;
        }
        time =formatter.format(date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
