/**
 * Program GUI Java untuk melakukan operasi CRUD data Matakuliah
 * 
 * @author Samuel Lekatompessy
 * @version 1.0
 * @since 2022-02-22
 * 
 * Copyright 2022 Samuel Lekatompessy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
  /**
   * Method ini digunakan untuk menghubungkan JDBC dengan Database MySQL
   * 
   * @return Connection Ini mengembalikan objek koneksi database
   * @throws SQLException
   */
  public static Connection bukaKoneksi() throws SQLException {
    String dbn = "db_tugas2";
    String url = "jdbc:mariadb://localhost:3306/" + dbn;
    String user = "root";
    String pwd = "";

    Connection con = null;
    try {
      con = DriverManager.getConnection(url, user, pwd);
      return con;
    } catch (SQLException e) {
      System.out.println("No Connection Open");
      return null;
    }
  }

  /**
   * Method ini merupakan method utama pada class Koneksi
   * 
   * @param args
   */
  public static void main(String[] args) {
    try {
      Connection con = Koneksi.bukaKoneksi();
      System.out.println(String.format("Connected to database %s " + "successfully.", con.getCatalog()));
    } catch (SQLException e) {
      System.out.println("No Connection Open");
    }
  }
}
