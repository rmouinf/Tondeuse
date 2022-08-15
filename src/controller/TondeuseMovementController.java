package controller;

import model.Tondeuse;
import model.Terrain;

import java.util.List;

public class TondeuseMovementController {
    private final Terrain terrain;
    private final List<Tondeuse> tondeuseList;

    private final List<String> tondeuseMovements;


    public TondeuseMovementController(Terrain terrain, List<Tondeuse> tondeuseList, List<String> tondeuseMovements) {
        this.terrain = terrain;
        this.tondeuseList = tondeuseList;
        this.tondeuseMovements = tondeuseMovements;
    }

    public void runMovements() {
        for (int i = 0; i <= tondeuseList.size() - 1; i++) {
            String mouvements = tondeuseMovements.get(i);
            for (int j = 0; j <= mouvements.length() - 1; j++) {
                switch (mouvements.charAt(j)) {
                    case 'D' -> {
                        tondeuseList.get(i).turnRight();
                        break;
                    }
                    case 'G' -> {
                        tondeuseList.get(i).turnLeft();
                        break;
                    }
                    case 'A' -> {
                        if (this.canMove(tondeuseList.get(i))) {
                            tondeuseList.get(i).move();
                        }
                        break;
                    }
                }
            }
        }

    }


    public boolean canMove(Tondeuse tondeuse) {
        boolean isCanMove = false;
        switch (tondeuse.getOrientation()) {
            case 'N' -> {
                if (tondeuse.getPosition().getY() <= Math.abs(this.terrain.getRightUpCornerPoint().getY()))
                    isCanMove = true;
                break;
            }
            case 'S' -> {
                if (tondeuse.getPosition().getY() > 0)
                    isCanMove = true;
                break;
            }
            case 'E' -> {
                if (tondeuse.getPosition().getX() <= Math.abs(this.terrain.getRightUpCornerPoint().getX()))
                    isCanMove = true;
                break;
            }
            case 'W' -> {
                if (tondeuse.getPosition().getX() > 0)
                    isCanMove = true;
                break;
            }
            default -> isCanMove = false;
        }
        return isCanMove;
    }
}
