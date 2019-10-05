package ru.r5am;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


/**
 * Чтение данных из JSON-файла
 */
public class ReadJson {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) throws IOException {

        // Читать данные из файла
        log.info("Читаем данные из JSON-файла");

        String jsonFileName = "data.json";
        Map<String, Map<String, String>> data;

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonFileName);

        if (null == inputStream) {
            log.error("Не нашёлся файл '{}'", jsonFileName);
        } else {
            data = objectMapper.readValue(inputStream, new TypeReference<Map<String, Map<String, String>>>(){});
            log.info("Json MAP:\n{}", data);
        }

    }

}
