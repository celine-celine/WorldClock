/*Hotel类用于模拟酒店的运营，Hotel类中，设置了五个不同的世界时钟，以及一个大堂服务生的手机，
* 可以获取不同地区的时间信息，并且可以通过服务生的手机来进行一次性校准。*/

public class Hotel {
    private Clock PekingClock, LondonClock, SydneyClock, MoscowClock, NewYorkClock;
    private CellPhone waiterPhone;

    /*初始化五个时钟的时间*/
    public Hotel() {
        PekingClock = new Clock("peking");
        LondonClock = new Clock("london");
        SydneyClock = new Clock("sydney");
        MoscowClock = new Clock("moscow");
        NewYorkClock = new Clock("newyork");
        waiterPhone = new CellPhone();
    }

    public void correctTime() {
        waiterPhone.correctTime(PekingClock, LondonClock, SydneyClock, MoscowClock, NewYorkClock);
    }


    public Clock getPekingClock() {
        return PekingClock;
    }

    public void setPekingClock(Clock pekingClock) {
        PekingClock = pekingClock;
    }

    public Clock getLondonClock() {
        return LondonClock;
    }

    public void setLondonClock(Clock londonClock) {
        LondonClock = londonClock;
    }

    public Clock getSydneyClock() {
        return SydneyClock;
    }

    public void setSydneyClock(Clock sydneyClock) {
        SydneyClock = sydneyClock;
    }

    public Clock getMoscowClock() {
        return MoscowClock;
    }

    public void setMoscowClock(Clock moscowClock) {
        MoscowClock = moscowClock;
    }

    public Clock getNewYorkClock() {
        return NewYorkClock;
    }

    public void setNewYorkClock(Clock newYorkClock) {
        NewYorkClock = newYorkClock;
    }

    public CellPhone getWaiterPhone() {
        return waiterPhone;
    }

    public void setWaiterPhone(CellPhone waiterPhone) {
        this.waiterPhone = waiterPhone;
    }
}
