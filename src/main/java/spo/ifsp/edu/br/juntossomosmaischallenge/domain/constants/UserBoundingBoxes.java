package spo.ifsp.edu.br.juntossomosmaischallenge.domain.constants;

import java.util.ArrayList;
import java.util.List;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.BoundingBox;

public class UserBoundingBoxes {
    private List<BoundingBox> specialUserBoundingBoxes;
    private List<BoundingBox> normalUserBoundingBoxes;
    private List<BoundingBox> laboriousUserBoundingBoxes;

    public UserBoundingBoxes() {
        specialUserBoundingBoxes = new ArrayList<>();
        normalUserBoundingBoxes = new ArrayList<>();
        laboriousUserBoundingBoxes = new ArrayList<>();

        specialUserBoundingBoxes.add(new BoundingBox(-46.361899, -34.276938, -15.411580, -2.196998));
        specialUserBoundingBoxes.add(new BoundingBox(-52.997614, -44.428305, -23.966413, -19.766959));

        normalUserBoundingBoxes.add(new BoundingBox(-54.777426, -46.603598, -34.016466, -26.155681));
    }

    public List<BoundingBox> getSpecialUserBoundingBoxes() {
        return specialUserBoundingBoxes;
    }

    public List<BoundingBox> getNormalUserBoundingBoxes() {
        return normalUserBoundingBoxes;
    }

    public List<BoundingBox> getLaboriousUserBoundingBoxes() {
        return laboriousUserBoundingBoxes;
    }
}
