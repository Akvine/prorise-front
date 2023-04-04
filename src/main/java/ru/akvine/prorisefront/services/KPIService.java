package ru.akvine.prorisefront.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.akvine.prorisefront.services.dto.GetKPIResponse;

@Service
public class KPIService {
    public Integer getValue() {
        String url = "http://localhost:8080/kpi"; // URL для получения данных
        RestTemplate restTemplate = new RestTemplate();
        GetKPIResponse data = restTemplate.getForObject(url, GetKPIResponse.class); // Отправляем GET-запрос и получаем ответ в объект MyClass
        System.out.println("Data: " + data.toString());
        return data.getCompletedTasks();
    }
}
