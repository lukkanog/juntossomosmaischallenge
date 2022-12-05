package spo.ifsp.edu.br.juntossomosmaischallenge.service;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.Coordinates;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.constants.UserBoundingBoxes;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserTypeService;

public class UserTypeService implements IUserTypeService {
    @Override
    public UserType getUserTypeByCoordinates(Coordinates coordinates) {
        UserBoundingBoxes userBoundingBoxes = new UserBoundingBoxes();

        var specialUserBoundingBoxes = userBoundingBoxes.getSpecialUserBoundingBoxes();

        for (var specialUserBoundingBox : specialUserBoundingBoxes) {
            if (specialUserBoundingBox.isInside(coordinates)) {
                return UserType.SPECIAL;
            }
        }

        var normalUserBoundingBoxes = userBoundingBoxes.getNormalUserBoundingBoxes();

        for (var normalUserBoundingBox : normalUserBoundingBoxes) {
            if (normalUserBoundingBox.isInside(coordinates)) {
                return UserType.NORMAL;
            }
        }

        return UserType.LABORIOUS;
    }
}
