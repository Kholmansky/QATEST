import com.bwsw.Client;
import com.bwsw.ClientResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by maximkholmansky on 30/10/16.
 */
public class HttpUrlResponseRequestTest {

    @Test
    public void validateResponseCode() throws java.lang.Exception {
        ClientResponse clientResponse = Client.sendGetRequest("http://dispatcher.netpoint-dc.com/sample.json");
        assertEquals(200, clientResponse.getResponseCode());
    }

    @Test
    public void validateResponseBody() throws java.lang.Exception {
        ClientResponse clientResponse = Client.sendGetRequest("http://dispatcher.netpoint-dc.com/sample.json");

        JsonNode schm = JsonLoader.fromFile(new File("src/main/resources/validationSchema.json"));
        JsonNode jsn = JsonLoader.fromString(clientResponse.getBody());
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schm);

        assertEquals(true, schema.validate(jsn).isSuccess());
    }
}



