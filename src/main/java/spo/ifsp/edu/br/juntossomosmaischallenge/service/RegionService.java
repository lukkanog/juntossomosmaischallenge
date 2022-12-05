package spo.ifsp.edu.br.juntossomosmaischallenge.service;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.Location;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IRegionService;

public class RegionService implements IRegionService {
    @Override
    public Region getRegionByLocation(Location location) {
        switch (location.getState().toUpperCase()) {
            case "ACRE":
            case "AMAZONAS":
            case "AMAPÁ":
            case "PARÁ":
            case "RONDÔNIA":
            case "RORAIMA":
            case "TOCANTINS":
                return Region.NORTH;
            case "ALAGOAS":
            case "BAHIA":
            case "CEARÁ":
            case "MARANHÃO":
            case "PARAÍBA":
            case "PERNAMBUCO":
            case "PIAUÍ":
            case "RIO GRANDE DO NORTE":
            case "SERGIPE":
                return Region.NORTHEAST;
            case "DISTRITO FEDERAL":
            case "GOIÁS":
            case "MATO GROSSO":
            case "MATO GROSSO DO SUL":
                return Region.MIDWEST;
            case "ESPÍRITO SANTO":
            case "MINAS GERAIS":
            case "RIO DE JANEIRO":
            case "SÃO PAULO":
                return Region.SOUTHEAST;
            case "PARANÁ":
            case "RIO GRANDE DO SUL":
            case "SANTA CATARINA":
                return Region.SOUTH;
            default:
                return null;
        } 
    }

}
