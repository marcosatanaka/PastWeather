package br.com.marcosatanaka.pastweather.service;

import br.com.marcosatanaka.pastweather.model.Constants;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

public class GeographicCoordinateFinder {

    private GeographicCoordinateFinder() {
    }

    public static String getLatitude(String city) throws Exception {
        Toponym toponym = getToponym(city);
        return String.valueOf(toponym.getLatitude());
    }

    public static String getLongitude(String city) throws Exception {
        Toponym toponym = getToponym(city);
        return String.valueOf(toponym.getLongitude());
    }

    private static Toponym getToponym(String city) throws Exception {
        WebService.setUserName(Constants.GEONAMES_APP_NAME);

        ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
        searchCriteria.setQ(city);

        ToponymSearchResult toponymSearchResult = WebService.search(searchCriteria);
        return toponymSearchResult.getToponyms()
                .stream()
                .findFirst()
                .orElseThrow(() -> new Exception("City not found!"));
    }

}
