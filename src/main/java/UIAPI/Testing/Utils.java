package UIAPI.Testing;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utils {

	public static <T> T getObjectFromJson(final String json, final Class<T> clazz) throws IOException {

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
     
        return mapper.readValue(json, clazz);
    }

    public static <T> List<T> getListfromJson(String json, final Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {

        final ObjectMapper mapper = new ObjectMapper();
    
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
        List<T> result = mapper.readValue(json, type);
        return result;
    }


    /**
     * Use this conversion to JSON object when only using it in the body part of the request
     * 
     * @param obj
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String convertToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        return new String(mapper.writeValueAsBytes(obj), "UTF-8");
    }

}
