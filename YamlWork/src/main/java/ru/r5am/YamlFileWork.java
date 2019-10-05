package ru.r5am;

import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlFileWork {

    private static final Logger log = LogManager.getLogger();

    /**
     * Read data from YAML file in "Map<String, Map<String, String>>"
     * @param yamlFileName File name with YAML
     * @return Data from YAML in "Map<String, Map<String, String>>"
     * @throws IOException When YAML file not found
     */
    public Map<String, Map<String, String>> readMapStringMap(String yamlFileName)  throws IOException {
        log.debug("readMapStringMap(): Read Map<String, Map<String, String>> from YAML file");
        Map<String, Map<String, String>> data;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(yamlFileName);

        if (null == inputStream) {
            log.error("File '{}' not found", yamlFileName);
            throw new IOException();
        } else {
            data = objectMapper.readValue(inputStream, new TypeReference<Map<String, Map<String, String>>>(){});
            log.debug("Yaml MAP:\n{}", data);
        }

        return data;

    }

}
