package spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.Location;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;

public interface IRegionService {
    Region getRegionByLocation(Location location);
}
