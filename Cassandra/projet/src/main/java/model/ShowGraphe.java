/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
public class ShowGraphe {
    
    public int IDCity;
    public int cas;

public ShowGraphe(int id , int cas){
this.IDCity=id;
this.cas=cas;
}

    public void setIDCity(int IDCity) {
        this.IDCity = IDCity;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public int getIDCity() {
        return IDCity;
    }

    public int getCas() {
        return cas;
    }

}
