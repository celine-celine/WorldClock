import java.text.SimpleDateFormat;
import java.util.Date;

/*Cellphone类用于模拟服务生的手机，它记录手机时间，并且可以通过手机时间进行校准世界时钟的时间。*/

public class CellPhone {
    private Date cellphoneDate;

    public void updateCellphoneDate(){
        cellphoneDate=new Date();
    }
    /*调用该函数可以校准五个时钟的时间。
    伦敦与UTC时间一致，北京比UTC时间早8小时，莫斯科比UTC时间早4小时，悉尼比UTC时间早10小时，纽约比UTC时间晚5小时*/
    public void correctTime(Clock PekingClock, Clock LondonClock, Clock SydneyClock, Clock MoscowClock, Clock NewYorkClock){
        updateCellphoneDate();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String baseTime = formatter.format(cellphoneDate);

        Date london = new Date();
        Date moscow = new Date();
        Date sydney = new Date();
        Date newyork = new Date();
        london.setTime(cellphoneDate.getTime()-28800000);
        moscow.setTime(cellphoneDate.getTime()-14400000);
        sydney.setTime(cellphoneDate.getTime()+7200000);
        newyork.setTime(cellphoneDate.getTime()-46800000);


        PekingClock.setTime(baseTime);
        LondonClock.setTime(formatter.format(london));
        SydneyClock.setTime(formatter.format(sydney));
        MoscowClock.setTime(formatter.format(moscow));
        NewYorkClock.setTime(formatter.format(newyork));
    }
}
