package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gP;

    public CollisionChecker(GamePanel gP) {
        
        this.gP = gP;
    }

    public int checkBuild (Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gP.build.length; i++) {

            if (gP.build[i] != null) {

                entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;

                gP.build[i].solidArea.width = gP.tileSize*gP.build[i].scaleX;
                gP.build[i].solidArea.height = gP.tileSize*gP.build[i].scaleY;

                gP.build[i].solidArea.x = gP.build[i].worldX + gP.build[i].solidAreaDefaultX;
                gP.build[i].solidArea.y = gP.build[i].worldY + gP.build[i].solidAreaDefaultY;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gP.build[i].solidArea)) {
                            if (gP.build[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gP.build[i].solidArea)) {
                            if (gP.build[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gP.build[i].solidArea)) {
                            if (gP.build[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gP.build[i].solidArea)) {
                            if (gP.build[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gP.build[i].solidArea.x = gP.build[i].solidAreaDefaultX;
                gP.build[i].solidArea.y = gP.build[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    public int checkTile(Entity entity) {

        int index = 999;

        for (int i = 0; i < gP.tileM.tile.length; i++) {

            if (gP.tileM.tile[i] != null) {

                int entityLeftWorldX = entity.worldX + entity.solidArea.x;
                int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
                int entityTopWorldY = entity.worldY + entity.solidArea.y;
                int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

                int entityLeftCol = entityLeftWorldX / gP.tileSize;
                int entityRightCol = entityRightWorldX / gP.tileSize;
                int entityTopRow = entityTopWorldY / gP.tileSize;
                int entityBottomRow = entityBottomWorldY / gP.tileSize;

                int tileNum1, tileNum2;

                switch (entity.direction) {
                    case "up":
                        entityTopRow = (entityTopWorldY - entity.speed) / gP.tileSize;
                        tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityTopRow];
                        tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityTopRow];

                        if (gP.tileM.tile[tileNum1].collision || gP.tileM.tile[tileNum2].collision) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entityBottomRow = (entityBottomWorldY + entity.speed) / gP.tileSize;
                        tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                        tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityBottomRow];

                        if (gP.tileM.tile[tileNum1].collision || gP.tileM.tile[tileNum2].collision) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        entityLeftCol = (entityLeftWorldX - entity.speed) / gP.tileSize;
                        tileNum1 = gP.tileM.mapTileNum[entityLeftCol][entityTopRow];
                        tileNum2 = gP.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                        if (gP.tileM.tile[tileNum1].collision || gP.tileM.tile[tileNum2].collision) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        entityRightCol = (entityRightWorldX + entity.speed) / gP.tileSize;
                        tileNum1 = gP.tileM.mapTileNum[entityRightCol][entityTopRow];
                        tileNum2 = gP.tileM.mapTileNum[entityRightCol][entityBottomRow];

                        if (gP.tileM.tile[tileNum1].collision || gP.tileM.tile[tileNum2].collision) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                }
            }
        }

        return index;
    }

    public int checkObject (Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gP.obj.length; i++) {

            if (gP.obj[i] != null) {

                entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;

                gP.obj[i].solidArea.x = gP.obj[i].worldX + gP.obj[i].solidAreaDefaultX;
                gP.obj[i].solidArea.y = gP.obj[i].worldY + gP.obj[i].solidAreaDefaultY;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gP.obj[i].solidArea)) {
                            if (gP.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gP.obj[i].solidArea)) {
                            if (gP.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gP.obj[i].solidArea)) {
                            if (gP.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gP.obj[i].solidArea)) {
                            if (gP.obj[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gP.obj[i].solidArea.x = gP.obj[i].solidAreaDefaultX;
                gP.obj[i].solidArea.y = gP.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    public int checkEntity(Entity entity, Entity[] target) {

        int index = 999;

        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {

                entity.solidArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidArea.y = entity.worldY + entity.solidAreaDefaultY;

                target[i].solidArea.x = target[i].worldX + target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].worldY + target[i].solidAreaDefaultY;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(target[i].solidArea)) {
                            entity.collisionOn = true;
                            index = i;
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
