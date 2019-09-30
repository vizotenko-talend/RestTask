package ua.org.izotenko.resttask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestTaskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestTaskApplicationTests {

    public static final String URL = "http://localhost:8080/strings/sortByLongestWord";

    public static String TEST_PAYLOAD = "{\"strings\": [\n" +
            "\n" +
            "\"Sound boy proceed to blast into the galaxy\",\n" +
            "\n" +
            "\"Go back rocket man into the sky you'll see\",\n" +
            "\n" +
            "\"Hear it all the time, come back rewind\",\n" +
            "\n" +
            "\"Aliens are watching up in the sky\",\n" +
            "\n" +
            "\"Sound boy process to blast into the galaxy\",\n" +
            "\n" +
            "\"No one gonna harm you\",\n" +
            "\n" +
            "\"They all want you to play I watch the birds of prey\"\n" +
            "\n" +
            "]}";


    public static String RESULT = "{\"result\": [\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"string\": \"Aliens are watching up in the sky\",\n" +
            "\n" +
            "\"longestWord\": 8\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"string\": \"Sound boy process to blast into the galaxy\",\n" +
            "\n" +
            "\"longestWord\": 7\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"string\": \"Sound boy proceed to blast into the galaxy\",\n" +
            "\n" +
            "\"longestWord\": 7\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"string\": \"Go back rocket man into the sky you'll see\",\n" +
            "\n" +
            "\"longestWord\": 6\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"string\": \"Hear it all the time, come back rewind\",\n" +
            "\n" +
            "\"longestWord\": 6\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]}\n" +
            "\n";

    private RestTemplate restTemplate = new RestTemplate();

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSortingStringsByLongestWord() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> request = new HttpEntity<>(TEST_PAYLOAD, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);

        AssertionErrors.assertEquals("values should be equal", mapper.readTree(RESULT), mapper.readTree(response.getBody()));
    }

}
