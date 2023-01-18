package avaswing;

import javax.swing.JLabel;

public class myLabel extends JLabel{
    private int id;
    private boolean isclicked=false;
    void setIdLabel(int ID) {
    	id=ID;
    }
    int getIdLabel() {
    	return id;
    }
    void setIsClicked(boolean isclick) {
    	isclicked=isclick;
    }
    boolean getIsClicked() {
    	return isclicked;
    }
}
