package edu.hitsz.RankingList;


import java.util.List;

public interface RankingDao {
    void findRankingid(int rankingid);

    List<Ranking> getAllRankings();

    void ADDRanking(Ranking ranking);
    void DELETERanking(int rankingid);
    
    void saveToFile(String filename);
    void loadFromFile(String filename);
}
