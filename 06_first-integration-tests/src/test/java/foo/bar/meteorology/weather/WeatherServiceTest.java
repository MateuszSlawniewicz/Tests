package foo.bar.meteorology.weather;

import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    private WeatherService weatherService =
            new WeatherService(
                    new TemperatureProvider(),
                    new RainfallProvider(),
                    new WindSpeedProvider()
            );

    @Test
    void testWeatherService() {
        Weather weather = weatherService.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }


    private TemperatureProvider mockTemperature = mock(TemperatureProvider.class);
    private RainfallProvider mockRain = mock(RainfallProvider.class);
    private WindSpeedProvider mockWindspeed = mock(WindSpeedProvider.class);
    private WeatherService mockWeatherServiec = new WeatherService(mockTemperature, mockRain, mockWindspeed);

    @Test
    void testWeather(){
        when(mockRain.getRainfallLevel())
                .thenReturn(200);
        when(mockTemperature.getTemperature())
                .thenReturn(15);
        when(mockWindspeed.getWindSpeed())
                .thenReturn(70);
        Weather weather = mockWeatherServiec.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }

}
