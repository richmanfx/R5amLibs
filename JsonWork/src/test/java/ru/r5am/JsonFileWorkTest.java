package ru.r5am;

import java.util.Map;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.apache.logging.log4j.LogManager;

class JsonFileWorkTest {

    private static final Logger log = LogManager.getLogger();

    @Test
    @DisplayName("Read data from JSON file in 'Map<String, Map<String, String>>'")
    void readMapStringMap() throws IOException {

        JsonFileWork jsonFileWork = new JsonFileWork();
        String jsonFileName = "data.json";
        Map<String, Map<String, String>> data = jsonFileWork.readMapStringMap(jsonFileName);
        log.debug("Json MAP:\n{}", data);

        assert data.toString()
               .equals(
                       "{Таблица 1={Поле 1=Значение 11, Поле 2=Значение 12, Поле 3=Значение 13, Поле 4=Значение 14, " +
                       "Поле 5=Значение 15}, Таблица 2={Поле 1=Значение 21, Поле 2=Значение 22, Поле 3=Значение 23, " +
                       "Поле 4=Значение 24, Поле 5=Значение 25}}");
    }

}
