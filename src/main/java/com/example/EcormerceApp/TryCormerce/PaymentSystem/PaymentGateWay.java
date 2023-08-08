package com.example.EcormerceApp.TryCormerce.PaymentSystem;

import okhttp3.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;
public class PaymentGateWay {

    public String Payment(BigDecimal amount, BigInteger transactionid,String paymentNumber){
        String status="";
        String uuid= UUID.randomUUID().toString();
        try {

             String encodeString="";
            String token="";
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\r\"providerCallbackHost\":\"https://webhook.site/3d2aa56b-7a1a-4876-9119-92e44dd0270c\"\n\r}");
            Request request = new Request.Builder()
                    .url("https://sandbox.momodeveloper.mtn.com/v1_0/apiuser")
                    .method("POST", body)
                    .addHeader("X-Reference-Id", uuid)
                    .addHeader("Ocp-Apim-Subscription-Key", "e10c57c33f024370878f4f81f99cd3a8")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(uuid);
            System.out.println(response);

            OkHttpClient client2 = new OkHttpClient.Builder().build();
            MediaType mediaType2 = MediaType.parse("application/json");
            RequestBody body2 = RequestBody.create(mediaType, "");
            Request request2 = new Request.Builder()
                    .url("https://sandbox.momodeveloper.mtn.com/v1_0/apiuser/" + uuid + "/apikey")
                    .method("POST", body2)
                    .addHeader("Ocp-Apim-Subscription-Key", "e10c57c33f024370878f4f81f99cd3a8")
                    .build();
            Response response2 = client2.newCall(request2).execute();
            System.out.println(response2);
            String val=response2.body().string();
            JSONObject object=new JSONObject(val);
            String apikey=object.getString("apiKey");
            System.out.println(apikey);
            String combine=uuid+":"+apikey;
            byte[] encode= Base64.getUrlEncoder().encode(combine.getBytes(StandardCharsets.UTF_8));
            encodeString=new String(encode,StandardCharsets.UTF_8);
            System.out.println(encodeString);

            OkHttpClient client3 = new OkHttpClient.Builder().build();
            MediaType mediaType3 = MediaType.parse("text/plain");
            RequestBody body3 = RequestBody.create(mediaType3, "");
            Request request3 = new Request.Builder()
                    .url("https://sandbox.momodeveloper.mtn.com/collection/token/")
                    .method("POST", body3)
                    .addHeader("Authorization", "Basic "+ encodeString)
                    .addHeader("Ocp-Apim-Subscription-Key", "e10c57c33f024370878f4f81f99cd3a8")
                    .build();
            Response response3 = client3.newCall(request3).execute();
            String val3=response3.body().string();
            JSONObject object3=new JSONObject(val3);
            token=object3.getString("access_token");
            System.out.println(token);

            OkHttpClient client7 = new OkHttpClient().newBuilder().build();
            MediaType mediaType7 = MediaType.parse("application/json");
            RequestBody requestBody = RequestBody.create(mediaType7, "{\r\n  \"amount\": \"9\",\r\n  \"currency\": \"EUR\",\r\n  \"externalId\": \"86867566\",\r\n  \"payer\": {\r\n    \"partyIdType\": \"MSISDN\",\r\n    \"partyId\": \"0549670461\"\r\n  },\r\n  \"payerMessage\": \"PAYMENTS\",\r\n  \"payeeNote\": \"NOTE\"\r\n}");
            Request request7 = new Request.Builder()
                    .url("https://sandbox.momodeveloper.mtn.com/collection/v1_0/requesttopay")
                    .method("POST", requestBody)
                    .addHeader("Authorization", "Bearer " +token)
                    .addHeader("X-Reference-Id", uuid)
                    .addHeader("X-Target-Environment", "sandbox")
                    .addHeader("Content-Type", "application/json")

                    .addHeader("Ocp-Apim-Subscription-Key", "56cb0c81f59b444993bab82196f5e90d")
                    .build();
            Response response7 = client7.newCall(request7).execute();
            String payment=response.body().string();

            System.out.println(response7);
            OkHttpClient client5 = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType5 = MediaType.parse("text/plain");

            Request request5 = new Request.Builder()
                    .url("https://sandbox.momodeveloper.mtn.com/collection/v1_0/requesttopay/"+uuid)
                    .method("GET", null)
                    .addHeader("Ocp-Apim-Subscription-Key", "e10c57c33f024370878f4f81f99cd3a8")
                    .addHeader("X-Target-Environment", "sandbox")
                    .addHeader("Authorization", "Bearer "+token)
                    .build();
            Response response5 = client5.newCall(request5).execute();
            String val6=response5.body().string();
            JSONObject object6=new JSONObject(val6);
             status=object6.getString("status");
            System.out.println(val6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
return status;
    }
}
