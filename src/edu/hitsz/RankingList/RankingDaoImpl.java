package edu.hitsz.RankingList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RankingDaoImpl implements RankingDao{
    private List<Ranking> rankings;

    public RankingDaoImpl(){
        rankings = new ArrayList<>();
        rankings.add(new Ranking(3, "testUserName", 100, "2025-12-12 12:12:12"));
        rankings.add(new Ranking(2, "testUserName", 200, "2025-12-13 12:12:12"));
        rankings.add(new Ranking(1, "testUserName", 300, "2025-12-14 12:12:12"));
    }

    @Override
    public void findRankingid(int rankingid) {
        for (Ranking ranking : rankings) {
            if (ranking.getRankingid() == rankingid){
                System.out.println("名次:[" + ranking.getRankingid() + "]玩家名:[" + ranking.getGamername() + "]分数:[" + ranking.getScore() + "]时间:[" + ranking.getRecordtime() + "]");
                return;
            }
        }
        System.out.println("未找到名次为[" + rankingid + "]的记录");
    }

    @Override
    public List<Ranking> getAllRankings() {
        return rankings;
    }

    @Override
    public void ADDRanking(Ranking ranking) {
        // 先添加记录
        rankings.add(ranking);

        // 重新分配排名ID，确保排名连续且正确
        sortid();
        System.out.println("添加成功" + "名次:[" + ranking.getRankingid() + "]玩家名:[" + ranking.getGamername() + "]分数:[" + ranking.getScore() + "]时间:[" + ranking.getRecordtime() + "]");
    }
    private void sortid(){
        rankings.sort((r1, r2) -> Integer.compare(r2.getScore(), r1.getScore()));
        for (int i = 0; i < rankings.size(); i++) {
            rankings.get(i).setRankingid(i + 1);
        }
    }
    @Override
    public void DELETERanking(int rankingid) {
        boolean found = false;
        for (Ranking ranking : rankings) {
            if (ranking.getRankingid() == rankingid) {
                rankings.remove(ranking);
                found = true;
                System.out.println("删除成功" + "名次:[" + ranking.getRankingid() + "]玩家名:[" + ranking.getGamername() + "]分数:[" + ranking.getScore() + "]时间:[" + ranking.getRecordtime() + "]");
                break;
            }
        }
        if (found) {
            // 删除后重新分配排名ID，确保排名连续
            sortid();
        } else {
            System.out.println("未找到名次为[" + rankingid + "]的记录");
        }
    }

    @Override
    public void saveToFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream osw = new ObjectOutputStream(fos);
            osw.writeObject(rankings);
            osw.close();
            fos.close();
            System.out.println("排行榜数据已保存到文件: " + filename);
        } catch (IOException e) {
            System.err.println("保存文件失败: " + e.getMessage());
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            rankings = (List<Ranking>) ois.readObject();
            ois.close();
            fis.close();
            
            // 加载后重新排序并分配排名ID
            sortid();
            System.out.println("排行榜数据已从文件加载: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在，将使用空排行榜");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("加载文件失败: " + e.getMessage());
        }
    }

    public void OutputRankings(){
        for (Ranking ranking : rankings){
            System.out.println("名次:[" + ranking.getRankingid() + "]玩家名:[" + ranking.getGamername() + "]分数:[" + ranking.getScore() + "]时间:[" + ranking.getRecordtime() + "]");
        }
    }
}
