package mfecapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MfecApplication1 {

    public static void main(String[] args) {

        String localPath = new java.io.File("").getAbsolutePath();
        Data data = new Data();
        PromotionP1 p1 = new PromotionP1();
        JSONArray jArry = new JSONArray();

        try {

            BufferedReader br = new BufferedReader(new FileReader(localPath + "/data/promotion1.log"));

            String sCurrentLine;
            int index = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                if (data.read(sCurrentLine)) {
                    if (data.getPromotion().equals("P1")) {
                        p1.charge(data);
                        JSONObject jObjd = new JSONObject();
                        jObjd.put("id", index++);
                        jObjd.put("mobileNo", p1.getMobileNo());
                        jObjd.put("serviceCharge", p1.getServiceCharge());
                        jArry.add(jObjd);
                    }
                }
            }

            String jStr = "{\"items\":";
            jStr += jArry.toJSONString();
            jStr += "}";
                    
            File fileCon = new File(localPath + "/data/output.json");
            fileCon.createNewFile();
            FileOutputStream fos = new FileOutputStream(fileCon);
            fos.write(jStr.getBytes());
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
