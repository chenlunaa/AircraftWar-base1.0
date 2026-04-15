package edu.hitsz.tool;

public class ToolFactory {
    public static BaseTool CreatTool (int type, int LocationX, int LocationY) {
        switch (type) {
            case 1:
                return new BloodTool(LocationX, LocationY, (int)(Math.random() * 2 + 3) - 2, (int)(Math.random() * 2 + 3) - 2, 1);

            case 2:
                return new FireTool(LocationX, LocationY, (int)(Math.random() * 2 + 3) - 2, (int)(Math.random() * 2 + 3) - 2, 2);

            case 3:
                return new FirePlusTool(LocationX, LocationY, (int)(Math.random() * 2 + 3) - 2, (int)(Math.random() * 2 + 3) - 2, 3);

            case 4:
                return new BombTool(LocationX, LocationY, (int)(Math.random() * 2 + 3) - 2, (int)(Math.random() * 2 + 3) - 2, 4);

            default:
                return new FreezeTool(LocationX, LocationY, (int)(Math.random() * 2 + 3) - 2, (int)(Math.random() * 2 + 3) - 2, 5);

        }
    }
}
