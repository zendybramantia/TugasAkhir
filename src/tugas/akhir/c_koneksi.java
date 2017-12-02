package tugas.akhir;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



/**
 *
 * @author SMK TELKOM
 */
public class c_koneksi {
    Connection koneksi;
    public Connection getConnection(){
        try {
           koneksi=DriverManager.getConnection("jdbc:mysql://localhost/tugas_akhir","root","");
           JOptionPane.showMessageDialog(null,"Tersimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return koneksi;
    }
}
