package mfecapplication1;

public class Data {
    
    private String date;
    private String startTime;
    private String endTime;
    private String mobileNo;
    private String promotion;
    
    public boolean read(String data){
        String[] dArry = data.split("\\|");
        if(dArry.length == 5){
            this.date = dArry[0];
            this.startTime = dArry[1];
            this.endTime = dArry[2];
            this.mobileNo = dArry[3];
            this.promotion = dArry[4];
            return true;
        }
        return false;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String getStartTime(){
        return this.startTime;
    }
    
    public String getEndTime(){
        return this.endTime;
    }
    
    public String getMobileNo(){
        return this.mobileNo;
    }
    
    public String getPromotion(){
        return this.promotion;
    }
    
}
