package org.nmefc.tsunmai.entity;

import javax.persistence.Id;

import javax.persistence.*;


@Entity
@Table(name="Sys_Menus",schema="tsunami",catalog="")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int MenuID;
    private int MenuTypeID;
    private String MenuTitle;
    private String MenuContent;
    private String MenuUrl;

    private int MenuLevel;
    private int ParentID;
    private int MenuState;
    private int MenuOrder;
    private String MenuIconClass;

    private String MenuSelectIconClass;
    private int MenuColorID;
    private int MenuBackColorID;
    private int MenuSelectable;

    @Id
    @Column(name="ID")
    public int getID(){
        return this.ID;
    }
    public void setID(int id){
        this.ID=id;
    }

    @Basic
    @Column(name="MenuID")
    public int getMenuID(){
        return this.MenuID;
    }

    public void setMenuID(int id){
        this.MenuID=id;
    }

    @Basic
    @Column(name="MenuTypeID")
    public int getMenuTypeID(){
        return this.MenuTypeID;
    }

    public void setMenuTypeID(int id){
        this.MenuTypeID =id;
    }


    @Basic
    @Column(name="MenuTitle")
    public String getMenuTitle(){
        return this.MenuTitle;
    }

    public void setMenuTitle(String title){
        this.MenuTitle=title;
    }

    @Basic
    @Column(name="MenuContent")
    public String getMenuContent(){
        return this.MenuContent;
    }

    public void setMenuContent(String menuContent){
        this.MenuContent=menuContent;
    }

    @Basic
    @Column(name="MenuUrl")
    public String getMenuUrl(){
        return this.MenuUrl;
    }

    public void setMenuUrl(String menuUrl){
        this.MenuUrl=menuUrl;
    }

    @Basic
    @Column(name="MenuLevel")
    public int getMenuLevel(){
        return this.MenuLevel;
    }

    public void setMenuLevel(int level){
        this.MenuLevel=level;
    }

    @Basic
    @Column(name="ParentID")
    public int getParentID(){
        return this.ParentID;
    }

    public void setParentID(int parentID){
        this.ParentID=parentID;
    }

    @Basic
    @Column(name="MenuState")
    public int getMenuState(){
        return this.MenuState;
    }

    public void setMenuState(int menuState){
        this.MenuState=menuState;
    }

    @Basic
    @Column(name="MenuOrder")
    public int getMenuOrder(){
        return this.MenuOrder;
    }

    public void setMenuOrder(int memuOrder){
        this.MenuOrder=memuOrder;
    }

    @Basic
    @Column(name="MenuIconClass")
    public String getMenuIconClass(){
        return this.MenuIconClass;
    }

    public void setMenuIconClass(String menuIconClass){
        this.MenuIconClass=menuIconClass;
    }

    @Basic
    @Column(name="MenuSelectIconClass")
    public String getMenuSelectIconClass(){
        return this.MenuSelectIconClass;
    }

    public void setMenuSelectIconClass(String menuSelectIconClass){
        this.MenuSelectIconClass=menuSelectIconClass;
    }

    @Basic
    @Column(name="MenuColorID")
    public int getMenuColorID(){
        return this.MenuColorID;
    }

    public void setMenuColorID(int menuColorID){
        this.MenuColorID=menuColorID;
    }

    @Basic
    @Column(name="MenuBackColorID")
    public int getMenuBackColorID(){
        return this.MenuBackColorID;
    }

    public void setMenuBackColorID(int menuBackColorID){
        this.MenuBackColorID=menuBackColorID;
    }

    @Basic
    @Column(name="MenuSelectable")
    public int getMenuSelectable(){
        return this.MenuSelectable;
    }

    public void setMenuSelectable(int menuSelectable){
        this.MenuSelectable=menuSelectable;
    }




}
