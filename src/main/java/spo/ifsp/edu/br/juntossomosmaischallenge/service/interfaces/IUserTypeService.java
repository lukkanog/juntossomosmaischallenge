package spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.Coordinates;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;

public interface IUserTypeService {
    UserType getUserTypeByCoordinates(Coordinates coordinates);
}
