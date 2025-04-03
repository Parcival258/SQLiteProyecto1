package com.andres_lasso.test.model;

public class Constants {

    public static  String DB_NAME = "test.db";

    public static  int NAME_VERSION = 14;


    public static String SENETENCIACIUDAD = "create table Ciudad (cod integer primary key autoincrement, name text)";
    public static String SENTENCEDATOS = "create table Datos (cod integer primary key autoincrement, name text)";
    public static String SENTENCEBARRIOS = "create table Barrios (cod integer primary key autoincrement, name text)";
    public static String SENTENCEDEPARTAMENTO = "create table Departamento (cod integer primary key autoincrement, name text)";

}
