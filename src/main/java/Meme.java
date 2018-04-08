import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Meme {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.memes.tube/method/templates.get")
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        Map res = mapper.readValue(body, Map.class);
        System.out.println(((Map)((List)((Map)res.get("response")).get("items")).get(0)).get("url"));
    }
}
