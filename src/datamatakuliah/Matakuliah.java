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

public class Matakuliah {
  private String kode;
  private String nama;
  private int sks;
  private String kode_pras;

  /**
   * Method ini digunakan untuk membentuk data Matakuliah ke dalam bentuk objek.
   * 
   * @param kode
   * @param nama
   * @param sks
   * @param kode_pras
   */
  public Matakuliah(String kode, String nama, int sks, String kode_pras) {
    this.kode = kode;
    this.nama = nama;
    this.sks = sks;
    this.kode_pras = kode_pras;
  }

  /**
   * Method ini mengembalikan data kode Matakuliah
   * 
   * @return String Ini mengembalikan kode Matakuliah
   */
  public String getKode() {
    return this.kode;
  }

  /**
   * Method ini mengembalikan data nama Matakuliah
   * 
   * @return String Ini mengembalikan nama Matakuliah
   */
  public String getNama() {
    return this.nama;
  }

  /**
   * Method ini mengembalikan data sks Matakuliah
   * 
   * @return int Ini mengembalikan sks Matakuliah
   */
  public int getSks() {
    return this.sks;
  }

  /**
   * Method ini mengembalikan data kode_pras Matakuliah
   * 
   * @return String Ini mengembalikan kode_pras Matakuliah
   */
  public String getKodePrasyarat() {
    return this.kode_pras;
  }
}
