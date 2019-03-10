package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;

public class WeatherAlarmNotifier {

    private WeatherService weatherService;

    public WeatherAlarmNotifier(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherAlarmLevel raiseLevelIfNeccessary() {
        Weather weather = weatherService.getWeather();
        int counter = 0;
        if (weather.getTemprature() >= 35) {
            counter++;
        }
        if (weather.getWindSpeed() >= 100) {
            counter++;
        }
        if (weather.getRainfall() >= 100 && counter > 1) {
            return WeatherAlarmLevel.FIRST_LEVEL;
        } else if (weather.getRainfall() > 100 && counter == 0) {
            return WeatherAlarmLevel.THIRD_LEVEL;
        }
        if (counter >= 2) {
            return WeatherAlarmLevel.FIRST_LEVEL;
        } else if (counter > 0) {
            return WeatherAlarmLevel.SECOND_LEVEL;
        }


        return WeatherAlarmLevel.ALL_OK;
    }


}
//    eśli temperatura wzrasta powyżej 35 stopni Celsjusza, oznacza to, że serwis powinien wywołać alarm SECOND_LEVEL
//        jeżeli wiatr wieje szybciej niż 100 km / h, oznacza to, że serwis powinien wywołać alarm SECOND_LEVEL
//        jeśli opady są powyżej 100 mm, oznacza to, że serwis powinien wywołać alarm THIRD_LEVEL
//        jeśli występuje więcej niż jeden alarm powyżej, oznacza to, że serwis powinien zgłosić alarm FIRST_LEVEL
//        dla wszystkich innych sytuacji serwis powinien podnosić status ALL_OK Możesz od razu przejść
//        do punktu 3, który może ułatwić ci życie, niwelując długi czas wykonywania.