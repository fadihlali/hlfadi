/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isetj.guicassandra.jpa;

import com.datastax.driver.core.ResultSet;
import com.isetj.guicassandra.dao.CassandraConnector;
import java.util.ArrayList;
import java.util.List;
import model.City;



public class CityEntity extends City {
 public static String TableName = "City";
 public CityEntity(int IDCity,String CityName, double Longitude, double
latitude, double population) {
 super(IDCity,CityName, Longitude, latitude, population);
 }
 public void createCityTable() {
 StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
 .append(TableName).append("(")
 .append("IDCity uuid PRIMARY KEY, ")
 .append("CityName text,")
 .append("Longitude double,")
 .append("Latitude double,")
 .append("population double);");
 String query = sb.toString();
 CassandraConnector.createTable(query);
 }
 public static List<City> selectAll(String keyspaceName) {
 StringBuilder sb
 = new StringBuilder("SELECT * FROM ").append(keyspaceName).append(".").append(TableName);
 String query = sb.toString();
 ResultSet rs = CassandraConnector.ExecuteQuery(query);
 List<City> cities = new ArrayList<City>();
 rs.forEach(r -> {
 cities.add(new City(
 r.getInt("IDCity"),
 r.getString("CityName"),
 r.getDouble("Longitude"),
 r.getDouble("Latitude"),
 r.getDouble("Population")
 ));
 });
 return cities;
 }
 public static List<City> selectCityByName(String CityName) {
 StringBuilder sb
 = new StringBuilder("SELECT * FROM ")

.append(TableName)
 .append(" Where CityName='")
 .append(CityName)
 .append("');");
 String query = sb.toString();
 ResultSet rs = CassandraConnector.ExecuteQuery(query);
 List<City> cities = new ArrayList<City>();
 rs.forEach(r -> {
 cities.add(new City(
 r.getInt("IDCity"),
 r.getString("CityName"),
 r.getDouble("Longitude"),
 r.getDouble("Latitude"),
 r.getDouble("Population")
 ));
 });
 return cities;
 }
 public static void insertCity(City city,String keyspaceName) {
 StringBuilder sb = new StringBuilder("INSERT INTO ")
 .append(keyspaceName).append(".")
 .append(TableName)
 .append("(IDCity, CityName, Longitude,Latitude,Population)")
 .append("VALUES (").append(city.getIDCity()).append(", '")
 .append(city.getCityName()).append("',")
 .append(city.getLongitude()).append(",")
 .append(city.getLatitude()).append(",")
 .append(city.getPopulation()).append(");");
 String query = sb.toString();
 CassandraConnector.ExecuteQuery(query);
 }
 public static int selectpopulation(int id) {
 StringBuilder sb
 = new StringBuilder("SELECT ").append("Population ").append("from ")
.append(TableName)
 .append(" Where IDCity= '")
 .append(id)
 .append("');");
 String query = sb.toString();
 ResultSet rs = CassandraConnector.ExecuteQuery(query);
 return rs.getAvailableWithoutFetching();
 }
}
