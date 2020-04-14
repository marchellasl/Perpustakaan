package perpustakaan;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ControllerPeminjaman {
    ViewPeminjaman viewPeminjaman;
    ModelPerpustakaan modelPerpustakaan;
    
    public ControllerPeminjaman(ViewPeminjaman viewPeminjaman, ModelPerpustakaan modelPerpustakaan)
    {
        this.viewPeminjaman = viewPeminjaman;
        this.modelPerpustakaan = modelPerpustakaan;
        
        if(modelPerpustakaan.getBanyakDataPeminjaman() != 0)
        {
         String dataPeminjaman[][] = modelPerpustakaan.readPeminjaman();
         viewPeminjaman.tabel.setModel((new JTable(dataPeminjaman, viewPeminjaman.namaKolom)).getModel());
        }
        else 
        {
         JOptionPane.showMessageDialog(null, "Data Not Found");
        }
        
        viewPeminjaman.btnSimpan.addActionListener((ActionEvent e)->
        {
           
           String noPinjam = viewPeminjaman.getNoPinjam();
           String nis = viewPeminjaman.getNis();
           String kodeBuku = viewPeminjaman.getKodeBuku();
           String tanggalPinjam = viewPeminjaman.getTanggalPinjam();
           String tanggalKembali = viewPeminjaman.getTanggalKembali();
           String nik = viewPeminjaman.getNik();
           
           modelPerpustakaan.insertPeminjaman(noPinjam, nis, kodeBuku, tanggalPinjam, tanggalKembali, nik);
           String dataPeminjaman[][] = modelPerpustakaan.readPeminjaman();
           viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
        });
        
        viewPeminjaman.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                int baris = viewPeminjaman.tabel.getSelectedRow();
                int kolom = viewPeminjaman.tabel.getSelectedColumn();
                
                String dataterpilih = viewPeminjaman.tabel.getValueAt(baris, 0).toString();
                String nisterpilih = viewPeminjaman.tabel.getValueAt(baris, 1).toString();
                String namaterpilih = viewPeminjaman.tabel.getValueAt(baris, 2).toString();
                String kelasterpilih = viewPeminjaman.tabel.getValueAt(baris, 3).toString();
                String kodeterpilih = viewPeminjaman.tabel.getValueAt(baris, 4).toString();
                String judulterpilih = viewPeminjaman.tabel.getValueAt(baris, 5).toString();                
                String penerbitterpilih = viewPeminjaman.tabel.getValueAt(baris, 6).toString();
                String pinjamterpilih = viewPeminjaman.tabel.getValueAt(baris, 7).toString(); 
                String kembaliterpilih = viewPeminjaman.tabel.getValueAt(baris, 8).toString();
                String lamaterpilih = viewPeminjaman.tabel.getValueAt(baris, 9).toString();
                String dendaterpilih = viewPeminjaman.tabel.getValueAt(baris, 10).toString();
                String karyawanterpilih = viewPeminjaman.tabel.getValueAt(baris, 11).toString();
                String nikterpilih = viewPeminjaman.tabel.getValueAt(baris, 12).toString();
                
                System.out.println(dataterpilih);
                
            viewPeminjaman.btnHapus.addActionListener((ActionEvent x)->
            {
                modelPerpustakaan.deletePeminjaman(dataterpilih);
                String dataPeminjaman[][] = modelPerpustakaan.readPeminjaman();
                viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
            });
            
            viewPeminjaman.btnPrint.addActionListener((ActionEvent x)->
            {
                CetakPeminjaman cetak = new CetakPeminjaman(dataterpilih, nisterpilih, namaterpilih, kelasterpilih, kodeterpilih, judulterpilih, penerbitterpilih, pinjamterpilih, kembaliterpilih, lamaterpilih, dendaterpilih, karyawanterpilih, nikterpilih);
                viewPeminjaman.dispose();
            });
            }
                    
        });
        
        viewPeminjaman.btnRefresh.addActionListener((ActionEvent e)->
        {
            viewPeminjaman.tfnoPinjam.setText("");
            viewPeminjaman.tfnis.setText("");
            viewPeminjaman.tfkodeBuku.setText("");
            viewPeminjaman.tftanggalPinjam.setText("");
            viewPeminjaman.tftanggalKembali.setText("");
            viewPeminjaman.tfnik.setText("");
            viewPeminjaman.tfnamaAnggota.setText("");
            viewPeminjaman.tfkelas.setText("");
            viewPeminjaman.tfjudulBuku.setText("");
            viewPeminjaman.tfnamaPenerbit.setText("");
            viewPeminjaman.tflamaPinjam.setText("");
            viewPeminjaman.tfdenda.setText("");
            viewPeminjaman.tfnamaKaryawan.setText("");

            String dataPeminjaman[][] = modelPerpustakaan.readPeminjaman();
            viewPeminjaman.tabel.setModel(new JTable(dataPeminjaman, viewPeminjaman.namaKolom).getModel());
        });  
        
        viewPeminjaman.btnKeluar.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {

                ViewAwal awal = new ViewAwal();
                viewPeminjaman.dispose();
            }
        });
        
        viewPeminjaman.btnCari.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String search = viewPeminjaman.getNoPinjam();
                String dataPeminjaman[][] = modelPerpustakaan.searchPeminjaman(search);
                viewPeminjaman.tabel.setModel(new JTable (dataPeminjaman, viewPeminjaman.namaKolom).getModel());
            }
        });
        
        viewPeminjaman.tfnis.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                String nis = viewPeminjaman.getNis();
                modelPerpustakaan.keteranganAnggota(nis);
                String namaAnggota = modelPerpustakaan.PnamaKet;
                String kelas = modelPerpustakaan.PkelasKet;
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                 viewPeminjaman.tfnamaAnggota.setText(namaAnggota); 
                 viewPeminjaman.tfkelas.setText(kelas);
                }
                 
            }   
        });
        
        viewPeminjaman.tfkodeBuku.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                String kode = viewPeminjaman.getKodeBuku();
                modelPerpustakaan.keteranganBuku(kode);
                String judul = modelPerpustakaan.PjudulBuku;
                String penerbit = modelPerpustakaan.PpenerbitBuku;
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                 viewPeminjaman.tfjudulBuku.setText(judul); 
                 viewPeminjaman.tfnamaPenerbit.setText(penerbit);
                }
            }   
        });
        
        viewPeminjaman.tftanggalKembali.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                String awal = viewPeminjaman.getTanggalPinjam();
                String kembali = viewPeminjaman.getTanggalKembali();
                modelPerpustakaan.keteranganLama(awal, kembali);
                String lamaTanggal = modelPerpustakaan.PlamaPinjam;
                String denda = modelPerpustakaan.PbayarDenda;
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                    viewPeminjaman.tflamaPinjam.setText(lamaTanggal + " hari");
                    viewPeminjaman.tfdenda.setText(denda);
                    
                    
                }
            }   
        });
        
        viewPeminjaman.tfnik.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                String nik = viewPeminjaman.getNik();
                modelPerpustakaan.keteranganKaryawan(nik);
                String namaK = modelPerpustakaan.PnamaKaryawan;
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {  
                    viewPeminjaman.tfnamaKaryawan.setText(namaK);
                }
            }   
        });
        

        
  }
              
}
