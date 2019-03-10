package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherAlarmNotifierTest {

    private WeatherAlarmNotifier alarmNotifier =
            new WeatherAlarmNotifier(
                    new WeatherService(
                            new TemperatureProvider(),
                            new RainfallProvider(),
                            new WindSpeedProvider()
                    )
            );
    private TemperatureProvider mockTemperature = mock(TemperatureProvider.class);
    private RainfallProvider mockRain = mock(RainfallProvider.class);
    private WindSpeedProvider mockWindspeed = mock(WindSpeedProvider.class);
    private WeatherService mockWeatherServiec = new WeatherService(mockTemperature, mockRain, mockWindspeed);

    @Test
    void testWeatherAlarm() {
        when(mockRain.getRainfallLevel())
                .thenReturn(50);
        when(mockTemperature.getTemperature())
                .thenReturn(35);
        when(mockWindspeed.getWindSpeed())
                .thenReturn(100);


        WeatherAlarmNotifier weatherAlarmNotifier = new WeatherAlarmNotifier(mockWeatherServiec);
        WeatherAlarmLevel weatherAlarmLevel = weatherAlarmNotifier.raiseLevelIfNeccessary();
        Logger.getLogger("JUnit 5").info("Current weather : " + weatherAlarmLevel.toString());
        assertNotNull(weatherAlarmLevel);
    }

    private WeatherService mockWeatherServic2 = mock(WeatherService.class);

    @Test
    void alarmTest2() {

        when(mockWeatherServic2.getWeather()).thenReturn(new Weather(35, 100, 50));
        WeatherAlarmNotifier weatherAlarmNotifier = new WeatherAlarmNotifier(mockWeatherServic2);
        WeatherAlarmLevel weatherAlarmLevel = weatherAlarmNotifier.raiseLevelIfNeccessary();
        Logger.getLogger("JUnit 5").info("Current weather : " + weatherAlarmLevel.toString());
        assertNotNull(weatherAlarmLevel);

    }

}
