package spo.ifsp.edu.br.juntossomosmaischallenge.domain.helpers;

import java.util.ArrayList;
import java.util.List;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;

public class RegionHelper {
    public static List<Region> getRegionsByString(String regions) {
        List<Region> regionsList = new ArrayList<>();
        if (regions != null) {
            String[] regionsArray = regions.split(",");
            for (String region : regionsArray) {
                regionsList.add(Region.valueOf(region.toUpperCase()));
            }
        }
        return regionsList;
    }
}
