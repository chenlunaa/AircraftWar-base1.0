package edu.hitsz.RankingList;

import java.io.Serializable;

public class Ranking implements Serializable {
    private int rankingid;
    private String gamername;
    private int score;
    private String recordtime;

    public Ranking(int rankingid, String gamername, int score, String recordtime){
        this.rankingid = rankingid;
        this.gamername = gamername;
        this.score = score;
        this.recordtime = recordtime;
    }

    public int getRankingid(){
        return this.rankingid;
    }
    public String getGamername(){
        return this.gamername;
    }
    public int getScore(){
        return this.score;
    }
    public String getRecordtime(){
        return this.recordtime;
    }
    public void setRankingid(int rankingid){
        this.rankingid = rankingid;
    }
    public void setGamername(String gamername) {
        this.gamername = gamername;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setRecordtime(String recordtime) {
        this.recordtime = recordtime;
    }

}
