package main;

import building.*;
import entity.*;
import object.*;

public class AssetSetter {

    GamePanel gP;

    public AssetSetter(GamePanel gP) {
        this.gP = gP;
    }

    public void setBuilding () {

        gP.build[0] = new BuildTower(gP);
        gP.build[0].worldX = ((3 - 1) / 2) * gP.tileSize; //83 is note column
        gP.build[0].worldY = (13 - 1) * gP.tileSize;

        gP.build[1] = new BuildHotDog(gP);
        gP.build[1].worldX = ((37 - 1) / 2) * gP.tileSize; //83 is note column
        gP.build[1].worldY = (27 - 1) * gP.tileSize;

        gP.build[2] = new BuildStage(gP);
        gP.build[2].worldX = ((77 - 1) / 2) * gP.tileSize; //83 is note column
        gP.build[2].worldY = (7 - 1) * gP.tileSize;

        gP.build[3] = new BuildTruck(gP);
        gP.build[3].worldX = ((43 - 1) / 2) * gP.tileSize; //83 is note column
        gP.build[3].worldY = (2 - 1) * gP.tileSize;

        gP.build[4] = new BuildHouse(gP);
        gP.build[4].worldX = ((7 - 1) / 2) * gP.tileSize; //83 is note column
        gP.build[4].worldY = (28 - 1) * gP.tileSize;
    }

    public void setObject() {

        gP.obj[0] = new ObjNote1(gP);
        gP.obj[0].worldX = ((83 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[0].worldY = (28 - 1) * gP.tileSize;

        gP.obj[1] = new ObjArt(gP);
        gP.obj[1].worldX = ((21 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[1].worldY = (13 - 1) * gP.tileSize;

        gP.obj[2] = new ObjFlower(gP, 1);
        gP.obj[2].worldX = ((26 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[2].worldY = (19 - 1) * gP.tileSize;

        gP.obj[3] = new ObjFlower(gP, 2);
        gP.obj[3].worldX = ((29 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[3].worldY = (19 - 1) * gP.tileSize;

        gP.obj[4] = new ObjBrush(gP);
        gP.obj[4].worldX = ((71 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[4].worldY = (18 - 1) * gP.tileSize;
        gP.obj[4].pickable = true;

        gP.obj[5] = new ObjNote2(gP);
        gP.obj[5].worldX = ((11 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[5].worldY = (2 - 1) * gP.tileSize;

        gP.obj[6] = new ObjTrash(gP);
        gP.obj[6].worldX = ((39 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[6].worldY = (23 - 1) * gP.tileSize;

        gP.obj[7] = new ObjTrash(gP);
        gP.obj[7].worldX = ((75 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[7].worldY = (32 - 1) * gP.tileSize;

        gP.obj[8] = new ObjBoard(gP);
        gP.obj[8].worldX = ((39 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[8].worldY = (20 - 1) * gP.tileSize;

        gP.obj[9] = new ObjTrash(gP);
        gP.obj[9].worldX = ((75 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[9].worldY = (7 - 1) * gP.tileSize;

        gP.obj[10] = new ObjSoil(gP, 0);
        gP.obj[10].worldX = ((7 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[10].worldY = (32 - 1) * gP.tileSize;

        gP.obj[11] = new ObjSoil(gP, 1);
        gP.obj[11].worldX = ((11 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[11].worldY = (32 - 1) * gP.tileSize;

        gP.obj[12] = new ObjSoil(gP, 2);
        gP.obj[12].worldX = ((15 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[12].worldY = (32 - 1) * gP.tileSize;

        gP.obj[13] = new ObjFlower(gP, 0);
        gP.obj[13].worldX = ((27 - 1) / 2) * gP.tileSize; //83 is note column
        gP.obj[13].worldY = (19 - 1) * gP.tileSize;
    }

    public void setNPC() {

        gP.npc[0] = new NPC_Vyse(gP);
        gP.npc[0].worldX = ((47 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[0].worldY = (34 - 1) * gP.tileSize;

        gP.npc[1] = new NPC_Nomu(gP);
        gP.npc[1].worldX = ((51 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[1].worldY = (23 - 1) * gP.tileSize;

        gP.npc[2] = new NPC_Bee(gP);
        gP.npc[2].worldX = ((67 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[2].worldY = (13 - 1) * gP.tileSize;

        gP.npc[3] = new NPC_Puppycat(gP);
        gP.npc[3].worldX = ((69 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[3].worldY = (13 - 1) * gP.tileSize;

        gP.npc[4] = new NPC_Peridot(gP);
        gP.npc[4].worldX = ((61 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[4].worldY = (7 - 1) * gP.tileSize;

        gP.npc[5] = new NPC_Him(gP);
        gP.npc[5].worldX = ((73 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[5].worldY = (23 - 1) * gP.tileSize;

        gP.npc[6] = new NPC_Ruby(gP);
        gP.npc[6].worldX = ((83 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[6].worldY = (34 - 1) * gP.tileSize;

        gP.npc[7] = new NPC_Sean(gP);
        gP.npc[7].worldX = ((35 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[7].worldY = (28 - 1) * gP.tileSize;

        gP.npc[8] = new NPC_Florez(gP);
        gP.npc[8].worldX = ((13 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[8].worldY = (34 - 1) * gP.tileSize;

        gP.npc[9] = new NPC_Reaper(gP);
        gP.npc[9].worldX = ((47 - 1) / 2) * gP.tileSize; //83 is note column
        gP.npc[9].worldY = (19 - 1) * gP.tileSize;

    }
}
