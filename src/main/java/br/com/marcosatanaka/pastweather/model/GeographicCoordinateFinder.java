package br.com.marcosatanaka.pastweather.model;

import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

/**
 * Contains logic to get latitude and longitude of a city by name.
 */
public class GeographicCoordinateFinder {

    public static String getLatitudeForLocation(String city) throws Exception {
        Toponym toponym = getToponym(city);
        return String.valueOf(toponym.getLatitude());
    }

    public static String getLongitudeForLocation(String city) throws Exception {
        Toponym toponym = getToponym(city);
        return String.valueOf(toponym.getLongitude());
    }

    private static Toponym getToponym(String city) throws Exception {
        WebService.setUserName(Constants.GEONAMES_APP_NAME);

        ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
        searchCriteria.setQ(city);

        ToponymSearchResult searchResult = WebService.search(searchCriteria);
        return searchResult.getToponyms()
                .stream()
                .findFirst()
                .orElseThrow(() -> new Exception("City not found!"));
    }

}
