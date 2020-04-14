package perpustakaan;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModelPerpustakaan 
{
    String PnamaKet, PkelasKet, PjudulBuku, PpenerbitBuku, PlamaPinjam, PbayarDenda, PnamaKaryawan;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelPerpustakaan()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public void insertBuku(String kode, String judul, String pengarang, String penerbit, String tahun)
    {
        String kodeBuku = kode;
        int kodeHasil = Integer.parseInt(kodeBuku);
        String tahunBuku = tahun;
        int tahunHasil = Integer.parseInt(tahunBuku);
        try
        {
            String query = "INSERT INTO `buku` (`kode_buku`, `judul_buku`,`nama_pengarang`,`nama_penerbit`, `tahun_terbit`)"
                    + "VALUES ('"+kodeHasil+"','"+judul+"', '"+pengarang+"', '"+penerbit+"','"+tahunHasil+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataBuku()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `buku`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] readBuku()
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakDataBuku()][5];
            String query = "SELECT * FROM `buku`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("kode_buku");
                data[jmlData][1] = resultSet.getString("judul_buku");
                data[jmlData][2] = resultSet.getString("nama_pengarang");
                data[jmlData][3] = resultSet.getString("nama_penerbit");
                data[jmlData][4] = resultSet.getString("tahun_terbit");
                jmlData++;
                
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteBuku(String kode)
    {
        String kodeBuku = kode;
        int kodeterpilih = Integer.parseInt(kodeBuku);
        try{
            String query = "DELETE FROM `buku` WHERE `kode_buku` = '"+kodeterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedBuku(String searchKode)
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `buku` WHERE `kode_buku` LIKE '%"+searchKode+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] searchBuku(String searchKode)
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getSearchedBuku(searchKode)][5];
            String query = "SELECT * FROM `buku` WHERE `kode_buku` LIKE '%"+searchKode+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("kode_buku");
                data[jmlData][1] = resultSet.getString("judul_buku");
                data[jmlData][2] = resultSet.getString("nama_pengarang");
                data[jmlData][3] = resultSet.getString("nama_penerbit");
                data[jmlData][4] = resultSet.getString("tahun_terbit");
                jmlData++;
            }
            return data;
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertAnggota(String nis, String nama, String ttl, String jk, String agama, String kelas, String tgldaftar, String berlaku)
    {
        String tanggalLahir = ttl;
        String tanggalDaftar = tgldaftar;
        String berlakuHingga = berlaku;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(tanggalLahir, formatter);
        LocalDate date2 = LocalDate.parse(tanggalDaftar, formatter);
        LocalDate date3 = LocalDate.parse(berlakuHingga, formatter);

        try
        {
            String query = "INSERT INTO `anggota` (`NIS`, `nama`,`ttl`,`jenis_kelamin`, `agama`, `kelas`, `tanggal_daftar`, `berlaku_hingga`)"
                    + "VALUES ('"+nis+"','"+nama+"', '"+date1+"', '"+jk+"','"+agama+"', '"+kelas+"', '"+date2+"', '"+date3+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataAnggota()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `anggota`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] readAnggota()
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakDataAnggota()][8];
            String query = "SELECT * FROM `anggota`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("NIS");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("ttl");
                data[jmlData][3] = resultSet.getString("jenis_kelamin");
                data[jmlData][4] = resultSet.getString("agama");
                data[jmlData][5] = resultSet.getString("kelas");
                data[jmlData][6] = resultSet.getString("tanggal_daftar");
                data[jmlData][7] = resultSet.getString("berlaku_hingga");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteAnggota(String nis)
    {
        String nisAnggota = nis;
        int nisterpilih = Integer.parseInt(nisAnggota);
        try
        {
            String query = "DELETE FROM `anggota` WHERE `NIS` = '"+nisterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }
        catch(SQLException sql)
        {
            System.out.println(sql.getMessage());
        }
    }

    public void insertKaryawan(String nik, String nama, String jk, String golongan)
    {
        try
        {
            String query = "INSERT INTO `karyawan` (`NIK`, `nama_karyawan`,`jenis_kelamin`,`golongan`)"
                    + "VALUES ('"+nik+"','"+nama+"', '"+jk+"', '"+golongan+"')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataKaryawan()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `karyawan`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readKaryawan()
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakDataKaryawan()][7];
            String query = "SELECT * FROM `golongan` INNER JOIN `karyawan` ON `karyawan`.`golongan` = `golongan`.`golongan`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("NIK");
                data[jmlData][1] = resultSet.getString("nama_karyawan");
                data[jmlData][2] = resultSet.getString("jenis_kelamin");
                data[jmlData][3] = resultSet.getString("golongan");
                data[jmlData][4] = resultSet.getString("jabatan");
                data[jmlData][5] = resultSet.getString("tunjangan");
                data[jmlData][6] = resultSet.getString("jumlah_gaji");
                jmlData++;
                
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deleteKaryawan(String nik)
    {
        String nikKaryawan = nik;
        int nikterpilih = Integer.parseInt(nikKaryawan);
        try{
            String query = "DELETE FROM `karyawan` WHERE `NIK` = '"+nikterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedKaryawan(String searchNik)
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `golongan` INNER JOIN `karyawan` ON `karyawan`.`golongan` = `golongan`.`golongan`  WHERE `karyawan`.`NIK` LIKE '%"+searchNik+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
        
    public String[][] searchKaryawan(String searchNik)
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getSearchedKaryawan(searchNik)][7];
            String query = "SELECT * FROM `golongan` INNER JOIN `karyawan` ON `karyawan`.`golongan` = `golongan`.`golongan`  WHERE `karyawan`.`NIK` LIKE '%"+searchNik+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("NIK");
                data[jmlData][1] = resultSet.getString("nama_karyawan");
                data[jmlData][2] = resultSet.getString("jenis_kelamin");
                data[jmlData][3] = resultSet.getString("golongan");
                data[jmlData][4] = resultSet.getString("jabatan");
                data[jmlData][5] = resultSet.getString("tunjangan");
                data[jmlData][6] = resultSet.getString("jumlah_gaji");
                jmlData++;
            }
            return data;
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertPeminjaman(String no_pinjam, String nis, String kode_buku, String tanggal_pinjam, String tanggal_kembali, String nik)
    {
        String lama_pinjam, denda;
        String tanggalPinjam = tanggal_pinjam;
        String tanggalKembali = tanggal_kembali;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(tanggalPinjam, formatter);
        LocalDate date2 = LocalDate.parse(tanggalKembali, formatter);
        
        Period diff = Period.between(date1, date2);
        int bayarDenda;
        int lamaPinjam = diff.getDays();
        if(lamaPinjam>7)
        {
            bayarDenda = (lamaPinjam-7)*1000;
        }
        else
        {
            bayarDenda = 0;
        }

        
        try
        {
            String query = "INSERT INTO `peminjaman` (`no_pinjam`, `NIS`,`kode_buku`,`tanggal_pinjam`, `tanggal_kembali`, `lama_pinjam`, `denda`, `NIK`)"
                    + "VALUES ('"+no_pinjam+"','"+nis+"', '"+kode_buku+"', '"+date1+"','"+date2+"', '"+lamaPinjam+"','"+bayarDenda+"', '"+nik+"');";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Added");
            JOptionPane.showMessageDialog(null, "Data Added");
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakDataPeminjaman()
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * from `peminjaman`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readPeminjaman()
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakDataPeminjaman()][13];
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`NIS` = `anggota`.`NIS` JOIN `buku` ON `peminjaman`.`kode_buku` = `buku`.`kode_buku` JOIN `karyawan` ON `peminjaman`.`NIK` = `karyawan`.`NIK`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("no_pinjam");
                data[jmlData][1] = resultSet.getString("NIS");
                data[jmlData][2] = resultSet.getString("nama");
                data[jmlData][3] = resultSet.getString("kelas");
                data[jmlData][4] = resultSet.getString("kode_buku");                
                data[jmlData][5] = resultSet.getString("judul_buku");
                data[jmlData][6] = resultSet.getString("nama_penerbit");
                data[jmlData][7] = resultSet.getString("tanggal_pinjam");  
                data[jmlData][8] = resultSet.getString("tanggal_kembali");  
                data[jmlData][9] = resultSet.getString("lama_pinjam");     
                data[jmlData][10] = resultSet.getString("denda");
                data[jmlData][11] = resultSet.getString("nama_karyawan"); 
                data[jmlData][12] = resultSet.getString("NIK");                  
                jmlData++;
                
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void deletePeminjaman(String noPinjam)
    {
        String nomorPinjam = noPinjam;
        int noterpilih = Integer.parseInt(nomorPinjam);
        try{
            String query = "DELETE FROM `peminjaman` WHERE `no_pinjam` = '"+noterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public int getSearchedPeminjaman(String searchNoPinjam)
    {
        int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`NIS` = `anggota`.`NIS` JOIN `buku` ON `peminjaman`.`kode_buku` = `buku`.`kode_buku` JOIN `karyawan` ON `peminjaman`.`NIK` = `karyawan`.`NIK` WHERE `peminjaman`.`no_pinjam` LIKE '%"+searchNoPinjam+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] searchPeminjaman(String searchNoPinjam)
    {
        try
        {
            int jmlData = 0;
            String data[][] = new String[getSearchedPeminjaman(searchNoPinjam)][13];
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`NIS` = `anggota`.`NIS` JOIN `buku` ON `peminjaman`.`kode_buku` = `buku`.`kode_buku` JOIN `karyawan` ON `peminjaman`.`NIK` = `karyawan`.`NIK` WHERE `peminjaman`.`no_pinjam` LIKE '%"+searchNoPinjam+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("no_pinjam");
                data[jmlData][1] = resultSet.getString("NIS");
                data[jmlData][2] = resultSet.getString("nama");
                data[jmlData][3] = resultSet.getString("kelas");
                data[jmlData][4] = resultSet.getString("kode_buku");                
                data[jmlData][5] = resultSet.getString("judul_buku");
                data[jmlData][6] = resultSet.getString("nama_penerbit");
                data[jmlData][7] = resultSet.getString("tanggal_pinjam");  
                data[jmlData][8] = resultSet.getString("tanggal_kembali");  
                data[jmlData][9] = resultSet.getString("lama_pinjam");     
                data[jmlData][10] = resultSet.getString("denda");
                data[jmlData][11] = resultSet.getString("nama_karyawan"); 
                data[jmlData][12] = resultSet.getString("NIK");                  
                jmlData++;
            }
            return data;
            
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void keteranganAnggota(String nis)
    {
        try
        {
            String query = "SELECT * FROM `anggota` WHERE `NIS` LIKE '%"+nis+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                PnamaKet = resultSet.getString("nama");
                PkelasKet = resultSet.getString("kelas");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
    
    public void keteranganBuku(String kode)
    {
        try
        {
            String query = "SELECT * FROM `buku` WHERE `kode_buku` LIKE '%"+kode+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                PjudulBuku = resultSet.getString("judul_buku");
                PpenerbitBuku = resultSet.getString("nama_penerbit");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
    
    public void keteranganLama(String awal, String kembali)
    {
        String lama_pinjam, denda;
        String tanggalPinjam = awal;
        String tanggalKembali = kembali;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(tanggalPinjam, formatter);
        LocalDate date2 = LocalDate.parse(tanggalKembali, formatter);
        
        Period diff = Period.between(date1, date2);
        
        int waktu = diff.getDays();
        PlamaPinjam = Integer.toString(waktu);
        
        if(waktu>7)
        {
        int dendaBayar = (waktu-7)*1000;
        PbayarDenda = Integer.toString(dendaBayar);
        }
        else
        {
        int dendaBayar = 0;
        PbayarDenda = Integer.toString(dendaBayar);
        }
    }
    
    public void keteranganKaryawan(String nik)
    {
        try
        {
            String query = "SELECT * FROM `karyawan` WHERE `NIK` LIKE '%"+nik+"%';";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                PnamaKaryawan = resultSet.getString("nama_karyawan");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
   
}
