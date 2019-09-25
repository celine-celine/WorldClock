import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {
    Hotel h;

    /*每次测试前生成一个Hotel实例。*/
    @BeforeEach
    void init(){
        h = new Hotel();
    }

    /*测试时钟初始化，不要求时间精准，因此只需要检查是否完成了初始化即每个时钟的时间是否为空即可。*/
    @Test
    void testClockInitialization() {
        assertAll(() -> assertNotNull(h.getPekingClock().getTime()),
                () -> assertNotNull(h.getLondonClock().getTime()),
                () -> assertNotNull(h.getMoscowClock().getTime()),
                () -> assertNotNull(h.getSydneyClock().getTime()),
                () -> assertNotNull(h.getNewYorkClock().getTime()));
    }

    /*测试校准功能，分钟和秒数是相同的，确保小时之间的差值即可。*/
    @Test
    void testCorrectTime() {
        h.correctTime();

        String PTime = h.getPekingClock().getTime();
        int PH = (PTime.charAt(0) - '0') * 10 + PTime.charAt(1) - '0';

        String LTime = h.getLondonClock().getTime();
        int LH = (LTime.charAt(0) - '0') * 10 + LTime.charAt(1) - '0';
        LH = (LH + 8 + 24) % 24;

        String MTime = h.getMoscowClock().getTime();
        int MH = (MTime.charAt(0) - '0') * 10 + MTime.charAt(1) - '0';
        MH = (MH + 4 + 24) % 24;

        String STime = h.getSydneyClock().getTime();
        int SH = (STime.charAt(0) - '0') * 10 + STime.charAt(1) - '0';
        SH = (SH - 2 + 24) % 24;

        String NTime = h.getNewYorkClock().getTime();
        int NH = (NTime.charAt(0) - '0') * 10 + NTime.charAt(1) - '0';
        NH = (NH + 13 + 24) % 24;

        assertEquals(PH, LH);
        assertEquals(PH, MH);
        assertEquals(PH, SH);
        assertEquals(PH, NH);


        assertAll(() -> assertEquals(PTime.substring(3), LTime.substring(3)),
                () -> assertEquals(PTime.substring(4), MTime.substring(4)),
                () -> assertEquals(PTime.substring(5), STime.substring(5)),
                () -> assertEquals(PTime.substring(6), NTime.substring(6))
        );
    }
}