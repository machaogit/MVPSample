package com.machao.mvpsample.model;

/**
 * Copyright: Copyright (c) 2016年 All rights reserved. <br>
 * Version:V1.0.0 <br>
 * Author: machao <br>
 * Date:   16/6/16 14:49  <br>
 * Desc:    <br>
 */
public class Repos {

    private int id;

    private String name;

    private String full_name;

    private Owner owner;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setFull_name(String full_name){
        this.full_name = full_name;
    }
    public String getFull_name(){
        return this.full_name;
    }
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }

    public class Owner {
        private String login;

        private int id;

        private String avatar_url;

        public void setLogin(String login){
            this.login = login;
        }
        public String getLogin(){
            return this.login;
        }
        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setAvatar_url(String avatar_url){
            this.avatar_url = avatar_url;
        }
        public String getAvatar_url(){
            return this.avatar_url;
        }

    }

}
