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
package datamatakuliah;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import konfigurasi.Koneksi;

public class DBMatakuliah {
    /**
     * Method ini digunakan untuk menyusun query ambil data dari DB.
     * 
     * @return Ini mengembalikan daftar Objek Matakuliah {@link List}
     * @throws SQLException
     */
    public List<Matakuliah> list() throws SQLException {
        return this.list("");
    }

    /**
     * Method ini digunakan untuk menyusun query ambil data dari DB,
     * pada method ini dapat ditambahkan parameter keyword untuk mengambil data
     * secara spesifik.
     * 
     * @param keyword
     * @return Ini mengembalikan daftar Objek Matakuliah {@link List}
     * @throws SQLException
     */
    public List<Matakuliah> list(String keyword) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Matakuliah> matakuliahs = new ArrayList<Matakuliah>();
        String myQuery;

        try {
            connection = Koneksi.bukaKoneksi();
            // Cek keyword untuk menentukan query yang akan digunakan
            if (keyword != "") {
                myQuery = "SELECT * FROM matakuliah WHERE (matkul_kode LIKE ? OR matkul_nama LIKE ? OR matkul_kode_prasyarat LIKE ?)";
                statement = connection.prepareStatement(myQuery);
                statement.setString(1, "%" + keyword + "%");
                statement.setString(2, "%" + keyword + "%");
                statement.setString(3, "%" + keyword + "%");
            } else {
                myQuery = "SELECT * FROM matakuliah";
                statement = connection.prepareStatement(myQuery);
            }

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String kode = resultSet.getString("matkul_kode");
                String nama = resultSet.getString("matkul_nama");
                int sks = resultSet.getInt("matkul_sks");
                String kode_pras = resultSet.getString("matkul_kode_prasyarat");
                Matakuliah matakuliah = new Matakuliah(kode, nama, sks, kode_pras);
                matakuliahs.add(matakuliah);
            }
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
        }

        return matakuliahs;
    }

    /**
     * Method ini digunakan untuk menyusun query ubah data dari DB,
     * pada method ini wajib ditambahkan parameter kode, nama, sks, dan
     * kode_prasyarat untuk mengubah data.
     * 
     * @param kode           Ini adalah parameter pertama untuk method edit
     * @param nama           Ini adalah parameter kedua untuk method edit
     * @param sks            Ini adalah parameter ketiga untuk method edit
     * @param kode_prasyarat Ini adalah parameter keempat untuk method edit
     * @throws SQLException
     */
    public void edit(String kode, String nama, String sks, String kode_prasyarat) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String myQuery = "UPDATE matakuliah SET matkul_kode=?, matkul_nama=?, matkul_sks=?, matkul_kode_prasyarat=? WHERE matkul_kode=?";

        try {
            connection = Koneksi.bukaKoneksi();
            statement = connection.prepareStatement(myQuery);
            statement.setString(1, kode);
            statement.setString(2, nama);
            statement.setString(3, sks);
            statement.setString(4, kode_prasyarat);
            statement.setString(5, kode);
            statement.executeUpdate();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
        }
    }

    /**
     * Method ini digunakan untuk menyusun query tambah data ke DB,
     * pada method ini wajib ditambahkan parameter kode, nama, sks, dan
     * kode_prasyarat untuk menambah data.
     * 
     * @param kode           Ini adalah parameter pertama untuk method add
     * @param nama           Ini adalah parameter kedua untuk method add
     * @param sks            Ini adalah parameter ketiga untuk method add
     * @param kode_prasyarat Ini adalah parameter keempat untuk method add
     * @throws SQLException
     */
    public void add(String kode, String nama, String sks, String kode_prasyarat) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String myQuery = "INSERT INTO matakuliah (matkul_kode, matkul_nama, matkul_sks, matkul_kode_prasyarat) VALUES (?, ?, ?, ?)";

        try {
            connection = Koneksi.bukaKoneksi();
            statement = connection.prepareStatement(myQuery);
            statement.setString(1, kode);
            statement.setString(2, nama);
            statement.setString(3, sks);
            statement.setString(4, kode_prasyarat);
            statement.executeUpdate();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
        }
    }

    /**
     * Method ini digunakan untuk menyusun query hapus data dari DB,
     * pada method ini wajib ditambahkan parameter kode untuk menghapus data.
     * 
     * @param kode Ini adalah parameter pertama untuk method delete
     * @throws SQLException
     */
    public void delete(String kode) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String myQuery = "DELETE FROM matakuliah WHERE matkul_kode = ?";

        try {
            connection = Koneksi.bukaKoneksi();
            statement = connection.prepareStatement(myQuery);
            statement.setString(1, kode);
            statement.executeUpdate();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
        }
    }
}
