package ru.training.at.hw6.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalsColorsInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Provider {

    private static final String jsonPath = ConfigReader.getProperty("jsonPath");
    private static final ObjectMapper mapper = new ObjectMapper();
    private static Map<String, MetalsColorsInfo> map = new HashMap<>();

    @DataProvider(name = "jsonMetalsColorsData")
    public static Object[][] metalAndColorSetOfData() {

        try {
            byte[] mapData = Files.readAllBytes(Paths.get(jsonPath));
            map = mapper.readValue(mapData,
                    new TypeReference<HashMap<String, MetalsColorsInfo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        Object[][] jsonResultedData = new Object[map.size()][1];

        for (Map.Entry<String, MetalsColorsInfo> entry : map.entrySet()) {
            jsonResultedData[i][0] = entry.getValue();
            i++;
        }

        return jsonResultedData;
    }
}
