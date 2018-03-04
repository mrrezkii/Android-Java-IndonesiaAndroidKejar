package id.co.rezkiananda.learn.programminglanguage.Model;

import java.io.Serializable;

/**
 * Created by Rezki on 2/21/2018.
 */

public class Language implements Serializable {
    public String judul, deskripsi, gambar;

    public Language(String judul, String deskripsi, String gambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }
}
