package ru.r5am;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

class YamlFileWorkTest {

    private static final Logger log = LogManager.getLogger();

    @Test
    @DisplayName("Read data from YAML file in 'Map<String, Map<String, String>>'")
    void readMapStringMap() throws IOException {

        YamlFileWork yamlFileWork = new YamlFileWork();
        String yamlFileName = "data.yaml";
        Map<String, Map<String, String>> data = yamlFileWork.readMapStringMap(yamlFileName);
        log.debug("Yaml MAP:\n{}", data);

        assert data.toString()
                .equals(
                        "{Таблица 1={Поле 1=Значение 11, Поле 2=Значение 12, Поле 3=Значение 13, Поле 4=Значение 14, " +
                        "Поле 5=Значение 15}, Таблица 2={Поле 1=Значение 21, Поле 2=Значение 22, Поле 3=Значение 23, " +
                        "Поле 4=Значение 24, Поле 5=Значение 25}}");
    }
}
