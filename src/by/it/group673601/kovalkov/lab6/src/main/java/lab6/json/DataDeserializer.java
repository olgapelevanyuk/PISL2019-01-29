package lab6.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataDeserializer extends StdDeserializer<Date> {
    public DataDeserializer() {
        this(null);
    }

    protected DataDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String stringData = p.getValueAsString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(dateFormat.parse(stringData).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
