package ru.r5am;

import java.io.File;
import java.util.Map;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonFileWork {

    private static final Logger log = LogManager.getLogger();

    /**
     * Read data from JSON file in "Map<String, Map<String, String>>"
     * @param jsonFileName File name with JSON
     * @return Data from JSON in "Map<String, Map<String, String>>"
     * @throws IOException When JSON file not found
     */
    public Map<String, Map<String, String>> readMapStringMap(String jsonFileName)  throws IOException {

        log.debug("readMapStringMap(): Read Map<String, Map<String, String>> from JSON file");

        Map<String, Map<String, String>> data;
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = new File(getClass().getClassLoader().getResource(jsonFileName).getFile());
        } catch (NullPointerException ex) {
            log.error("File '{}' not found", jsonFileName);
            throw new NullPointerException();
        }

        data = objectMapper.readValue(file, new TypeReference<Map<String, Map<String, String>>>(){});
        log.debug("Json MAP:\n{}", data);

        return data;
    }

}
