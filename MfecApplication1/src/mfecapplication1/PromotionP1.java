package mfecapplication1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PromotionP1 {

    private double serviceCharge;
    private String mobileNo;

    public void charge(Data data) {
        try {
            String time1 = data.getStartTime();
            String time2 = data.getEndTime();

            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long diff = date2.getTime() - date1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000);

            double chargePerMinute = 1.00;
            double chargePerSecond = chargePerMinute / 60;

            if (diffMinutes > 0 || diffSeconds > 0) {
                this.serviceCharge = 3.00;
            }

            if (diffMinutes > 0) {
                diffMinutes = diffMinutes - 1;
                this.serviceCharge += (diffMinutes * chargePerMinute) + (diffSeconds * chargePerSecond);
            }

            this.mobileNo = data.getMobileNo();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public double getServiceCharge() {
        return this.serviceCharge;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }
}
