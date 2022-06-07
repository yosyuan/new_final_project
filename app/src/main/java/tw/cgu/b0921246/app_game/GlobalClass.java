package tw.cgu.b0921246.app_game;

import android.app.Application;

public class GlobalClass extends Application {
    private int totalPoints = 0;
    private int findPoints = 0;
    private int betPoints = 0;
    private int idiomPoints = 0;
    private int knowledgePoints = 0;
    private int prise = 0;
    private int colorPoints = 0;

    public void setTotalPoints(int points){
        this.totalPoints = points;
    }

    public int getTotalPoints(){
        return totalPoints;
    }

    public void setFindPoints(int points){
        this.findPoints = points;
    }

    public int getFindPoints(){
        return findPoints;
    }

    public void setBetPoints(int points){
        this.betPoints = points;
    }

    public int getBetPoints(){
        return betPoints;
    }

    public void setIdiomPoints(int points){
        this.idiomPoints = points;
    }

    public int getIdiomPoints(){
        return idiomPoints;
    }

    public void setKnowledgePoints(int points){
        this.knowledgePoints = points;
    }

    public int getKnowledgePoints(){
        return knowledgePoints;
    }

    public void setPrise(int prise){
        this.prise = prise;
    }

    public int getPrise(){
        return prise;
    }
    public void setColorPoints(int points){
        this.colorPoints = points;
    }

    public int getColorPoints(){
        return colorPoints;
    }

}
